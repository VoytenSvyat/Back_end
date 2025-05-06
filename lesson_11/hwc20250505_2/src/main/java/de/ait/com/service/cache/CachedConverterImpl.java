package de.ait.com.service.cache;

import de.ait.com.module.Conversion;
import de.ait.com.service.Converter;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public class CachedConverterImpl implements Converter {
    public Converter converter;
    public RateCache cache;


    @Override
    public Conversion convert(String from, String to, double amount) {
        from = from.toLowerCase().trim();
        to= to.toLowerCase().trim();
        CachedRate rate = cache.getRate(from, to); // обратились к кеш
        if (rate!=null) {
            Conversion conversion = new Conversion(from, to, new BigDecimal(amount));
            BigDecimal amountTo = rate.getRate() // умножаем BigDecimal на BigDecimal: rate*amount
                    .multiply(BigDecimal.valueOf(amount)).setScale(2, RoundingMode.HALF_UP);
            conversion.setAmountTo(amountTo);
            return conversion;
        } else {
            Conversion result = converter.convert(from, to, amount);
            cache.setRate(from,to, result.getRate());
            return result;
        }
    }
}

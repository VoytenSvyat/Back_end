package de.ait;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Base64;

public class Main {
    /*
    # 1
Ваша задача написать используя API https://api.imagga.com эндпоинт /text написать программу которая распознает текст на картинке. Для тестирования можно использовать
картинку https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg
Результат для этой картинки строка: "ОТВЕЧАЮ В СПРИНГЕ ЭТО УЖЕ ЕСТЬ"

     */
    private static final String API_KEY = "...";
    private static final String API_SECRET = "...";
    private static final String IMAGE_URL = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
    private static final String ENDPOINT = "https://api.imagga.com/v2/text";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Кодирование учетных данных в Base64
        String auth = API_KEY + ":" + API_SECRET;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + encodedAuth);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                ENDPOINT + "?image_url=" + IMAGE_URL, HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
    }
}

package de.ait.userapi.model;

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString

public class Product {
    @Setter
    private Long id;
    private String title;
    private BigDecimal price;
}

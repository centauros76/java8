package com.tistory.centauros.kevin.functionalInterface;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Rene on 2018-12-20.
 * auth : Rene
 */
public class FunctionalInterfaceExamples {

    public static void main(String[] args) {
        Product product = new Product(1L, "Nitendo", new BigDecimal("280.99"));
        System.out.println(product);

    }


}

@Data
@AllArgsConstructor
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

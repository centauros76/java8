package com.tistory.centauros.kevin.stream;

import com.tistory.centauros.kevin.functionalInterface.ConsumerExamples;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by Rene on 2018-12-28.
 * auth : Rene
 */
public class OptionalTest {

    public static void main(String[] args) {


        Optional<String> optional1 = Optional.of(new String("test"));
        Optional<String> optional2 = Optional.ofNullable(null);
        optional2.ifPresent(s -> System.out.println("ifPresent :: " + s));


        System.out.println("optional 1 :: " + optional1);
        System.out.println("optional 2 :: " + optional2);

    }
}

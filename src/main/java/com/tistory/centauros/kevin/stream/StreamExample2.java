package com.tistory.centauros.kevin.stream;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by Rene on 2018-12-28.
 * auth : Rene
 */
public class StreamExample2 {

    public static void main(String[] args) {
        System.out.println("toList :: " +
            Stream.of(1, 3, 3, 5, 5)
                  .filter(i -> i > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .collect(toList())
        );

        System.out.println("toSet :: " +
            Stream.of(1, 3, 3, 5, 5)
                  .filter(i -> i > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .collect(toSet())
        );

        System.out.println("joining :: " +
            Stream.of(1, 3, 3, 5, 5)
                  .filter(i -> i > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .distinct()
                  .collect(joining(",", "[", "]"))
        );

    }
}

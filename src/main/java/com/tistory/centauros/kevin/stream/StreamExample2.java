package com.tistory.centauros.kevin.stream;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by Rene on 2018-12-28.
 * auth : Rene
 */
public class StreamExample2 {

    public static void main(String[] args) {
//        System.out.println("toList :: " +
//            Stream.of(1, 3, 3, 5, 5)
//                  .filter(i -> i > 2)
//                  .map(i -> i * 2)
//                  .map(i -> "#" + i)
//                  .collect(toList())
//        );
//
//        System.out.println("toSet :: " +
//            Stream.of(1, 3, 3, 5, 5)
//                  .filter(i -> i > 2)
//                  .map(i -> i * 2)
//                  .map(i -> "#" + i)
//                  .collect(toSet())
//        );
//
//        System.out.println("joining :: " +
//            Stream.of(1, 3, 3, 5, 5)
//                  .filter(i -> i > 2)
//                  .map(i -> i * 2)
//                  .map(i -> "#" + i)
//                  .distinct()
//                  .collect(joining(",", "[", "]"))
//        );


        String param = "getElements(\".wrap_prod_top\");getElements(\"img, a.link_g._GC_, a.link_path._GC_, div.wrap_price .num_price\"); getText(); getArrayText(\"span\",\"2\")";
        List<String> function = Arrays.asList(param.split(";"));
        List<FunctionQueue> queues = function.stream().map(f -> splitParam(f)).collect(toList());
    }

    public static FunctionQueue splitParam(String f) {
        FunctionQueue queue = new FunctionQueue();
        String name = "";
        String param = "";

        List<String> temp = Arrays.asList(f.split("\\)"));
        for (String s : temp) {
            String[] split = s.split("\\(");
            //System.out.println(Arrays.asList(split));

            if (split.length > 1) {
                name = split[0].trim();
                param = split[1].trim();
            } else {
                name = split[0].trim();
            }
        }
        queue.setFunctionName(name);
        queue.setParam(param);

        System.out.println(queue.toString());

        return queue;
    }
}

@Data
class FunctionQueue {
    String functionName;
    String param;
}

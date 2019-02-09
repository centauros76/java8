package com.tistory.centauros;

import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Rene on 2018. 12. 11..
 * auth : Rene
 */
public class HelloWorld {

    public static void main(String[] args) {







//        String param = "getElements(\".wrap_prod_top\");merge(getElements(\"#rank-table .fi-t__link .fi-t__nText\");getLimit(\"10\");getEachText(););";

        String param = "getElements(\".wrap_prod_top\");getElements(\"#rank-table .fi-t__link .fi-t__nText\");getLimit(\"10\");getEachText();";

//        String[] output = StringUtils.splitByWholeSeparator(param, ";", 2);
//
//        Arrays.stream(output).forEach(System.out::println);


        List list = new ArrayList();
        list = splitQuery(param, list);
        //System.out.println("list :: " + list);

        //Pattern.compile(";").splitAsStream(param).peek(System.out::println).forEach(HelloWorld::splitParam);

        //중복 괄호가 있는지 확인
        //중복 괄호가 있으면
    }

    public static List splitQuery (String query, List list) {


        String[] output = StringUtils.splitByWholeSeparator(query, ";", 2);
        System.out.println(output[0] + "::" +output[1]);
        if (output[0].contains("merge")) {
            //list.add(splitParam(query));
        } else {
            //list.add(splitParam(output[0]));
        }

        if (output[1].length() > 0) {
            splitQuery(output[1], list);
        }

        return list;
    }


    public static FunctionQueue splitParam(String param) {
        FunctionQueue functionQueue = new FunctionQueue();
        String query = null;
        String functionName = null;
        query = StringUtils.substringBetween(param, "(", ")").replaceAll("\"","");
        query = param.substring(param.indexOf("(")+1, param.lastIndexOf(")")).replaceAll("\"","");
        functionName = param.split("\\(")[0];


        functionQueue.setFunctionName(functionName);
        functionQueue.setQuery(query);


        if ("merge".equals(functionName)) {
            List<FunctionQueue> mergeFunctionQueueList = new ArrayList<>();
            splitQuery(query, mergeFunctionQueueList);
            functionQueue.setFunctionQueueList(mergeFunctionQueueList);
        }

        System.out.println("funtionName :: " + functionName);
        System.out.println("query :: " + query);

        return functionQueue;

    }
}

@Data
class FunctionQueue {
    String functionName;
    String query;
    List<FunctionQueue> functionQueueList;
}

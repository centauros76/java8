package com.tistory.centauros.kevin.functionalInterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Rene on 2018-12-20.
 * auth : Rene
 */
public class FunctionalInterfaceExamples {

    static Product nintendoSwitch = new Product(1L, "Nintendo-Switch", new BigDecimal("299000"));
    static Product xbox = new Product(2L, "Xbox", new BigDecimal("349000"));
    static Product palyStation = new Product(3L, "PlayStation", new BigDecimal("399000"));
    static Product family = new Product(4L, "Nintendo-Family", new BigDecimal("59000"));
    static Product neogio = new Product(5L, "Neo-Gio", new BigDecimal("49000"));


    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(nintendoSwitch, xbox, palyStation, family, neogio);
        System.out.println(productList);

        //10만원 초과 목록
        List<Product> expensiveProductList = new ArrayList<>();
        for(Product product : productList) {
            if (product.getPrice().compareTo(new BigDecimal("100000")) > 0) {
                expensiveProductList.add(product);
            }
        }
        System.out.println("   old way :: " + expensiveProductList);

        Predicate<Product> expensiveFilter = product -> product.getPrice().compareTo(new BigDecimal("100000")) > 0;
        expensiveProductList = listFilter(productList, expensiveFilter);
        System.out.println("use filter :: " + expensiveProductList);
        
        //expensiveList에 50%할인 적용
        List<DiscountProduct> discountProductsList = new ArrayList<>();
        for(Product product : expensiveProductList) {
            discountProductsList.add(new DiscountProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        }
        System.out.println("         old way :: " + discountProductsList);

        discountProductsList = applyDistount(expensiveProductList, product -> new DiscountProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        System.out.println("use applyDiscount:: " + discountProductsList);

        //discountProduct List에서 15만원 이하 물품 찾기
        List<DiscountProduct> under15List = new ArrayList<>();
        Predicate<Product> lessOrEqual15 = product -> product.getPrice().compareTo(new BigDecimal("150000")) <= 0;
        under15List = listFilter(discountProductsList, lessOrEqual15);

        System.out.println(under15List);
        System.out.println(listFilter(productList, lessOrEqual15));



        //10만원 이하 목록
        List<Product> cheapProductList = new ArrayList<>();
        for(Product product : productList) {
            if(product.getPrice().compareTo(new BigDecimal("100000")) <=0 ) {
                cheapProductList.add(product);
            }
        }
        System.out.println("   old way :: " + cheapProductList);

        Predicate<Product> cheapFilter = product -> product.getPrice().compareTo(new BigDecimal("100000")) <= 0;
        cheapProductList = listFilter(productList, cheapFilter);
        System.out.println("use filter :: " + cheapProductList);


    }

    private static <T> List<T> listFilter(List<T> list, Predicate<? super T> filter) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (filter.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> applyDistount(List<T> list, Function<T, R> discountCondition) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(discountCondition.apply(t));
        }
        return result;
    }


}

@Data
@AllArgsConstructor
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

@ToString(callSuper = true)
class DiscountProduct extends Product {
    public DiscountProduct(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }
}

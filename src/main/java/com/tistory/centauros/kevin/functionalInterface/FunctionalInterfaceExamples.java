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
        expensiveProductList = filter(productList, expensiveFilter);
        System.out.println("use filter :: " + expensiveProductList);
        
        //expensiveList에 50%할인 적용
        List<DiscountProduct> discountProductsList = new ArrayList<>();
        for(Product product : expensiveProductList) {
            discountProductsList.add(new DiscountProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        }
        System.out.println("         old way :: " + discountProductsList);

        discountProductsList = map(expensiveProductList, product -> new DiscountProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        System.out.println("use applyDiscount:: " + discountProductsList);

        //discountProduct List에서 15만원 이하 물품 찾기
        Predicate<Product> lessOrEqual15 = product -> product.getPrice().compareTo(new BigDecimal("150000")) <= 0;
        List<DiscountProduct> under15List = filter(discountProductsList, lessOrEqual15);

        System.out.println(under15List);
        System.out.println(filter(productList, lessOrEqual15));



        //10만원 이하 목록
        List<Product> cheapProductList = new ArrayList<>();
        for(Product product : productList) {
            if(product.getPrice().compareTo(new BigDecimal("100000")) <=0 ) {
                cheapProductList.add(product);
            }
        }
        System.out.println("   old way :: " + cheapProductList);

        Predicate<Product> cheapFilter = product -> product.getPrice().compareTo(new BigDecimal("100000")) <= 0;
        cheapProductList = filter(productList, cheapFilter);
        System.out.println("use filter :: " + cheapProductList);

//        List<BigDecimal> prices = map(productList, product -> product.getPrice());
//        BigDecimal total = BigDecimal.ZERO;
//        for (BigDecimal price : prices) {
//            total = total.add(price);
//        }
        BigDecimal total = total(productList, product -> product.getPrice());
        System.out.println("product total price :: " + total);

        BigDecimal discountedTotal = total(discountProductsList, product -> product.getPrice());
        System.out.println("discounted product total price :: " + discountedTotal);



    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> filter) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (filter.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
        BigDecimal total = BigDecimal.ZERO;
        for(T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
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

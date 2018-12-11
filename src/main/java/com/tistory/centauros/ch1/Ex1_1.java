package com.tistory.centauros.ch1;

/**
 * Created by Rene on 2018. 12. 11..
 * auth : Rene
 */
public class Ex1_1 {


    int sum = 0;
    public void sum(int i) {
        sum += i;
    }

    public static void main(String[] args) {
        Ex1_1 ex1_1 = new Ex1_1();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) ex1_1.sum(i);
        }).start();
    }
}

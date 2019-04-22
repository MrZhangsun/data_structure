package com.zhangsun.study.datastructure.queue;

import java.util.Random;

/**
 * Function: Priority Queue Test
 *
 * @author zhangsunjiankun - 2019/4/22 下午8:06
 */
public class Main {

    public static void main(String[] args) {
       test1();
    }

    private static void test1() {
        int n = 10;
        Queue<Integer> prior = new PriorQueue<Integer>();
        Random random = new Random();
        for (int i = 0; i < n; i ++) {
            prior.enQueue(random.nextInt(1000));
        }

        System.out.println(prior);
        for (int i = 0; i < n; i ++) {
            System.out.println(prior.deQueue());
        }
    }
}

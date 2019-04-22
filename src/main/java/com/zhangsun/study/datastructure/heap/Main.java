package com.zhangsun.study.datastructure.heap;

import java.util.Random;

/**
 * Function:
 *
 * @author zhangsunjiankun - 2019/4/18 下午8:56
 */
public class Main {

    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();

        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<Integer>();
        for (int i = 0; i < n; i ++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < heap.size(); i ++) {
            Integer max = heap.extractMax();
            arr[i] = max;
            System.out.println(max);
        }

        for (int i = 1; i < n; i ++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalStateException("Error");
            }
        }

        System.out.println("Done");

    }
}

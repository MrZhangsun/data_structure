package com.zhangsun.study.datastructure.heap;

import java.util.Random;

/**
 * Function:
 *
 * @author zhangsunjiankun - 2019/4/18 下午8:56
 */
public class Main {

    public static void main(String[] args) {
       calculate();
    }

    private static void test1() {
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

    private static void replace(Integer val) {
        int n = 10;
        Random random = new Random();
        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<Integer>();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        System.out.println(heap);
        Integer max = heap.replace(val);
        System.out.printf("max: %d, new: %d ", max, val);
        System.out.println(heap);
    }

    private static long toHeap1() {
        long b = System.currentTimeMillis();
        int n = 1000000;
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<Integer>(arr);

        long e = System.currentTimeMillis();
        return e - b;
    }

    private static long toHeap2() {
        long b = System.currentTimeMillis();
        int n = 1000000;
        Random random = new Random();
        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<Integer>();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        long e = System.currentTimeMillis();
        return e - b;
    }

    private static void calculate() {
        long c1 = toHeap1();
        long c2 = toHeap2();
        long gap = c1 - c2;
        System.out.printf("Cost time millis: %d\n", gap);
        double seconds = gap / 1000000000.0;
        System.out.printf("Cost seconds: %f", seconds);
    }
}

package com.zhangsun.study.datastructure.queue;

import com.zhangsun.study.datastructure.heap.MaxBinaryHeap;

/**
 * Function: implement priority queue using max binary heap.
 *
 * @author zhangsunjiankun - 2019/4/22 下午7:56
 */
public class PriorQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxBinaryHeap maxBinaryHeap;

    public PriorQueue() {
        maxBinaryHeap = new MaxBinaryHeap();
    }

    public boolean isEmpty() {
        return maxBinaryHeap.isEmpty();
    }

    public int getSize() {
        return maxBinaryHeap.size();
    }

    public E getFront() {
        return (E) maxBinaryHeap.getMax();
    }

    public void enQueue(E e) {
        maxBinaryHeap.add(e);
    }

    public E deQueue() {
        return (E) maxBinaryHeap.extractMax();
    }

    @Override
    public String toString() {
        return "PriorQueue{" +
                "maxBinaryHeap=" + maxBinaryHeap +
                '}';
    }
}

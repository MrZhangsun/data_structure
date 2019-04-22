package com.zhangsun.study.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 最大二叉堆(完全平衡二叉树)
 * 根据最大二叉堆的结构，可以将整个数按照从上到下，从左到右依次添加到数组中，那么父节点与左右节点在数组中的位置有如下关系：
 * 父节点索引 = （左节点索引 - 1）/ 2  | （右节点索引 - 2）/ 2
 *            0
 *          /   \
 *        1      2
 *      /  \   /  \
 *    3     4 5
 *  3-1 = 2/2 = 1
 *  4-1 = 3/2 = 1(int 计算向下取整)
 * 左子节点索引 = 父节点索引 * 2 + 1
 * 右子节点索引 = 父节点索引 * 2 + 2
 *
 * @author zhangsunjiankun - 2019/4/16 下午6:57
 */
public class MaxBinaryHeap<E extends Comparable<E>> {

    private List<E> heap;

    public MaxBinaryHeap(int capacity) {
        heap = new ArrayList<E>(capacity);
    }

    public MaxBinaryHeap() {
        heap = new ArrayList<E>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * According to child node index to calculate its parent index
     *
     * @param index child index
     * @return parent index
     */
    private int parentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index: 0 doesn't have a parent");
        }
        return (index - 1) / 2;
    }

    /**
     * According to parent index to calculate left child node index
     *
     * @param index parent index
     * @return left node index
     */
    private int leftIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * According to parent index to calculate right child node index
     *
     * @param index parent index
     * @return right node index
     */
    private int rightIndex(int index) {
        return leftIndex(index) + 1;
    }

    /**
     * Add data to heap
     *
     * @param e element
     */
    public void add(E e) {
        heap.add(e);
        siftUp(heap.size() - 1);
    }

    /**
     * Sift out the position where the element should be placed
     * @param index the new element index
     */
    private void siftUp(int index) {

        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex(index))) > 0) {
            // exchange position
            swap(index, parentIndex(index));
            // Update original index to new index
            index = parentIndex(index);
        }
    }

    /**
     * Get the max element in heap
     */
    public E getMax() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap.get(0);
    }

    public E extractMax() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        // replace first element and last element
        E max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        // remove last element
        heap.remove(heap.size() - 1);
        // sift down the original last element to correct position
        siftDown(0);
        return max;
    }

    private void siftDown(int k) {
        // If the left child exit, then loop
        while (leftIndex(k) < heap.size()) {
            E p = heap.get(k);
            int l = leftIndex(k);
            int r = rightIndex(k);
            /*
             *            0
             *          /   \
             *        1      2
             *      /  \   /  \
             *    3     4 5
             */

            int bigIndex;
            if (r >= heap.size()) {
                bigIndex = l;
            } else {
                bigIndex = heap.get(l).compareTo(heap.get(r)) > 0 ? l : r;
            }

            if (p.compareTo(heap.get(bigIndex)) >= 0) {
                break;
            }

            swap(k, bigIndex);
            k = bigIndex;
        }
    }

    private void swap(int e1, int e2) {
        // Assign new element to temporary value
        E temp = heap.get(e1);
        // Assign parent value to new element
        heap.set(e1, heap.get(e2));
        // Assign temporary value to new element
        heap.set(e2, temp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}

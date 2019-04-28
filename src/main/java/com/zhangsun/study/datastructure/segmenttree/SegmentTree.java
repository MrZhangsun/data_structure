package com.zhangsun.study.datastructure.segmenttree;

import java.util.Arrays;

/**
 * Function: Line Tree
 *                a[0-7]
 *              /         \
 *          a[0-3]       a[4-7]
 *       /        \      /      \
 *   a[0-1]     a[2-3] a[4-5]   a[6-7]
 *  /    \     /   \   /    \   /    \
 *a[1] a[1] a[2] a[3]a[4] a[5] a[6] a[7]
 *
 *
 * 如果有N个元素要存储到线段树中，那么理论上需要最大4N的空间来存储。
 *
 * @author zhangsunjiankun - 2019/4/22 下午8:24
 */
public class SegmentTree<E> {

    private E[] array;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] array, Merger<E> merger) {
        this.merger = merger;
        this.array = array;
        tree = (E[]) new Object[array.length * 4];
        buildSegment(0, 0, array.length - 1);
    }

    public int size() {
        return array.length;
    }

    public E get(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return array[index];
    }

    private int leftChild(int parent) {
        return 2 * parent + 1;
    }

    private int rightChild(int parent) {
        return leftChild(parent) + 1;
    }

    private void buildSegment(int index, int l, int r) {
        if (r == l) {
            tree[index] = array[l];
            return;
        }

        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        int mid = l + (r - l) / 2;

        // Create left and right child tree
        buildSegment(leftChild, l, mid);
        buildSegment(rightChild, mid + 1, r);

        tree[index] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    /**
     * 线段树的区间查找
     *
     * @param queryL 区间左边界
     * @param queryR 区间右边界
     * @return 查找结果
     */
    public E query(int queryL, int queryR) {

        if (queryL < 0 || queryL >= tree.length || queryR < 0 || queryR >= tree.length || queryL > queryR) {
            throw new IllegalStateException("Illegal Index: l = " + queryL + " r = " + queryR);
        }
        return query(0, 0, tree.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (r == queryR && l == queryL) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (mid >= queryR) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else if(mid + 1 <= queryL) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

        return merger.merge(leftResult, rightResult);
    }
    @Override
    public String toString() {
        return "SegmentTree{" +
                "array=" + Arrays.toString(array) +
                ", tree=" + Arrays.toString(tree) +
                ", merger=" + merger +
                '}';
    }
}

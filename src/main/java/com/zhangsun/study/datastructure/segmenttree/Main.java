package com.zhangsun.study.datastructure.segmenttree;

/**
 * Function:
 *
 * @author zhangsunjiankun - 2019/4/22 下午9:03
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = new Integer[] {-2, 0, 3, -5, 2, 1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (segment1, segment2) -> segment1 + segment2);
        System.out.println(segmentTree);
    }
}

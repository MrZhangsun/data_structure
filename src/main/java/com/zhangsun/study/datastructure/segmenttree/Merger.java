package com.zhangsun.study.datastructure.segmenttree;

/**
 * Function:
 *
 * @author zhangsunjiankun - 2019/4/22 下午8:59
 */
@FunctionalInterface
public interface Merger<E> {

    /**
     * Merge two segments data
     */
    E merge(E segment1, E segment2);

}

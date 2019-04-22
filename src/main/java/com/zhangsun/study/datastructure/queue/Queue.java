package com.zhangsun.study.datastructure.queue;

/**
 * Function:
 *
 * @author zhangsunjiankun - 2019/4/22 下午7:54
 */
public interface Queue<E extends Comparable<E>> {

    boolean isEmpty();

    int getSize();

    E getFront();

    void enQueue(E e);

    E deQueue();
}

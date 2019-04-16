package com.zhangsun.study.datastructure.array;

/**
 * Function: Custom Array
 *
 * @author zhangsunjiankun - 2019/4/16 下午7:01
 */
@SuppressWarnings("unchecked")
public class Array<E> {

    private E[] array;
    private static final int DEFAULT_CAPACITY = 16;
    private final double refactor = 0.75;
    private int capacity;
    private int length;

    /**
     * Create Array and specify capacity
     * @param capacity capacity
     */
    public Array(int capacity) {
        array = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * Create Array by default capacity
     */
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * get length
     *
     * @return length
     */
    public int length() {
        return this.length;
    }

    /**
     * Check empty
     *
     * @return empty is true
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * Set value by index
     *
     * @param index position
     * @param e element
     */
    public void set(int index, E e) {
        if (index < 0 ) {
            throw new IllegalArgumentException("Invalid Array Index: " + index);
        }

        // resize
        int limit = (int) Math.floor(capacity * refactor);
        if (this.length >= limit) {
            resize(this.capacity * 2);
        }
        array[index] = e;
        length++;
    }

    /**
     * Remove elements by index
     *
     * @param index position
     */
    public E remove(int index) {
        E remove = null;
        if (index < 0 ) {
            throw new IllegalArgumentException("Invalid Array Index: " + index);
        }

        if (index >= this.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        // resize
        int limit = (int) Math.floor(capacity * (1.0 - refactor));
        if (this.length <= limit) {
            resize((int)Math.floor(this.capacity * 0.5));
        }
        E[] temp = (E[]) new Object[this.capacity];
        int j = 0;
        for (int i = 0; i < this.length; i++) {
            if (i == index) {
                remove = array[i];
                continue;
            }
            temp[j] = array[i];
            j++;
        }
        array = temp;
        length--;
        return remove;
    }

    /**
     * Add at the end of the array
     *
     * @param e element
     */
    public void add(E e) {
        set(length, e);
    }

    private void resize(int capacity) {
        this.capacity = capacity;
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < this.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Array[" );
        for (int i = 0; i < this.length; i++) {
            builder.append(array[i]);
            if (i < this.length - 1) {
                builder.append(",");
            }
        }

        builder.append("]");
        builder.append("\r\n");
        builder.append("Capacity: ");
        builder.append(this.capacity);
        return builder.toString();
    }
}

package com.zhangsun.study.datastructure.array;

/**
 * Function:
 *
 * @author zhangsunjiankun - 2019/4/16 下午7:26
 */
public class Main {

    public static void main(String[] args) {
        Array<String> array = new Array<String>(5);
        for(int i = 0; i < 5; i++) {
            array.add("Hello" + i);
        }

        System.out.println(array.length());
        System.out.println(array);

       for (int i = 0; i < 5; i++) {
           String remover = array.remove(0);
           System.out.println(array);
           System.out.println(remover);
       }
    }
}

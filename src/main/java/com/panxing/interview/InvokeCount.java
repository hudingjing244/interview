package com.panxing.interview;

import com.panxing.interview.util.TodoException;

import java.util.stream.IntStream;

/**
 * @author panxing
 * 考察java 常用类
 * 实现 count 方法, 使得 count 方法 第一次被调用 就返回1，第二次被调用 就返回2，第n次被调用，就返回n，支持并发调用
 */
public class InvokeCount {

    /**
     * @return 这个方法被调用的总次数，支持并发调用,注意线程安全
     */
    private static long count() {
        // todo
        throw new TodoException();
    }

    public static void main(String[] args) {
        int target = 10000;
        IntStream.range(1, target).parallel().forEach(value -> count());
        System.out.println("expect:" + target + ", cal: " + count());
    }


}

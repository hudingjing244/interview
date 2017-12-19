package com.panxing.interview;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * @author panxing
 */
public class InvokeCount {

    private static final AtomicLong COUNTER = new AtomicLong(0L);

    /**
     * @return 这个方法被调用的总次数，支持并发调用
     */
    private static long count() {
        return COUNTER.incrementAndGet();
    }

    public static void main(String[] args) {
        int target = 10000;
        IntStream.range(1, target).parallel().forEach(value -> count());
        System.out.println("expect:" + target + ", cal: " + count());
    }


}

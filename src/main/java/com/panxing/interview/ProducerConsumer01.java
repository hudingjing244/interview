package com.panxing.interview;

import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author panxing
 * 生产消费者模型， 实现 run 方法，使得 main方法能够在 多核 cpu 的机器上 尽快并且正确的运行完毕
 */
public class ProducerConsumer01 {

    private static final ThreadLocal<Random> RANDOM_THREAD_LOCAL = ThreadLocal.withInitial(Random::new);

    private static final LongAdder ADDER = new LongAdder();

    public static long produce() {
        try {
            Thread.sleep(RANDOM_THREAD_LOCAL.get().nextInt(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis();
    }

    public static void consume(long num) {
        try {
            Thread.sleep(RANDOM_THREAD_LOCAL.get().nextInt(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ADDER.increment();
    }


    /**
     * run 方法 就是 用 consume 掉 produce 生产的数据 targetNum 这么多次
     * todo 如何让这个程序更快跑完？
     */
    private static void run(long targetNum) {
        for (int i = 0; i < targetNum; i++) {
            long item = produce();
            consume(item);
        }
//        throw new TodoException();
    }

    public static void main(String[] args) {
        long target = 1000;

        long startTime = System.currentTimeMillis();
        run(target);

        System.out.println("耗时: " + (System.currentTimeMillis() - startTime) / 1000 + "秒");
        if (target != ADDER.longValue()) {
            System.out.println("没有调用完吧。。");
        }
        RANDOM_THREAD_LOCAL.remove();
    }

}

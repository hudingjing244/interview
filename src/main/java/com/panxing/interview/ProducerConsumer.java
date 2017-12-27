package com.panxing.interview;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author panxing
 */
public class ProducerConsumer {

    private static final ThreadLocal<Random> RANDOM_THREAD_LOCAL = new ThreadLocal<>();

    private static final LongAdder ADDER = new LongAdder();

    public static Random getRandom() {
        Random random = RANDOM_THREAD_LOCAL.get();
        if (random == null) {
            synchronized (ProducerConsumer.class) {
                random = RANDOM_THREAD_LOCAL.get();
                if (random == null) {
                    random = new Random();
                    RANDOM_THREAD_LOCAL.set(random);
                }
            }
        }
        return random;
    }

    public static long produce() {
        try {
            Thread.sleep(getRandom().nextInt(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis();
    }

    public static void consume(long num) {
        try {
            Thread.sleep(getRandom().nextInt(30));
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
//        for (int i = 0; i < targetNum; i++) {
//            long item = produce();
//            consume(item);
//        }
        // todo
        throw new NotImplementedException();
    }

    public static void main(String[] args) {
        long target = 1000;

        long startTime = System.currentTimeMillis();
        run(target);

        System.out.println("耗时: " + (System.currentTimeMillis() - startTime) / 1000 + "秒");
        if (target != ADDER.longValue()) {
            System.out.println("没有调用完吧。。");
        }
    }

}

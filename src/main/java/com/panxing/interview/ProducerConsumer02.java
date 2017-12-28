package com.panxing.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author panxing
 * 生产消费者模型 v2
 * <p>
 * 假设有一个爬虫系统，每次抓取请求，会生产 0到3 条数据
 * 然后每生产了10条数据的时候，就会把这10条合并成为一条数据并且存入mysql
 * <p>
 * 尝试加速这个过程
 */
public class ProducerConsumer02 {

    public static class Item {

    }

    private static final ThreadLocal<Random> RANDOM_THREAD_LOCAL = ThreadLocal.withInitial(Random::new);

    private static final LongAdder ADDER = new LongAdder();

    public static List<Item> produce() {
        Random random = RANDOM_THREAD_LOCAL.get();
        try {
            Thread.sleep(random.nextInt(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(new Item[random.nextInt(4)]);
    }

    public static void consume(List<Item> items) {
        if (items.size() != 10) {
            throw new RuntimeException("消费者每次只能消费10个");
        }
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
        List<Item> buff = new ArrayList<>();
        while (targetNum > 0) {
            List<Item> items = produce();
            buff.addAll(items);
            while (buff.size() > 10) {
                targetNum--;
                consume(buff.subList(0, 10));
                buff = buff.subList(10, buff.size());
            }
        }
    }

    public static void main(String[] args) {
        long target = 200;

        long startTime = System.currentTimeMillis();
        run(target);

        System.out.println("耗时: " + (System.currentTimeMillis() - startTime) / 1000 + "秒");
        if (target != ADDER.longValue()) {
            System.out.println("没有调用完吧。。");
        }
        RANDOM_THREAD_LOCAL.remove();
    }

}

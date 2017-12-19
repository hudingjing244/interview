package com.panxing.interview;

import java.net.SocketTimeoutException;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author panxing
 */
public class SimpleCache {

    private CountDao countDao = new CountDao();

    /**
     * countDao 的 queryCount 方法比较慢，每次查询都要等1秒多
     * 改动这个 getCountFromDb 方法，缓存数据，每3秒才调用一次 queryCount 刷新缓存
     * 注意
     * 1.客户端会并发调用这个方法
     * 2. queryCount 可能会报错 SocketTimeoutException
     */
    private long getCountFromDb() throws InterruptedException, SocketTimeoutException {
        return countDao.queryCount();
    }


    public static void main(String[] args) {
        SimpleCache cache = new SimpleCache();
        int target = 100;
        IntStream.range(1, target).parallel().forEach(value -> {
            try {
                System.out.println(cache.getCountFromDb());
            } catch (InterruptedException | SocketTimeoutException e) {
                e.printStackTrace();
            }
        });
    }
}


class CountDao {

    private Random rand = new Random();

    long queryCount() throws InterruptedException, SocketTimeoutException {
        Thread.sleep(1000);
        if (rand.nextInt(2) == 0) {
            throw new SocketTimeoutException("查询数据库超时！");
        }
        return System.currentTimeMillis() / 10000 % 10;
    }
}

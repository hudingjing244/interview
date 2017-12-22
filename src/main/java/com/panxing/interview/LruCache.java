package com.panxing.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author panxing
 */
public class LruCache<K, V> {

    private final int size;

    private int currentSize = 0;
    private Map<K, V> cache = new LinkedHashMap<>(16);

    public LruCache(int size) {
        this.size = size;
    }

    public void put(K k, V v) {
        V cacheValue = cache.get(k);
        if (currentSize < size || cacheValue != null) {
            if (cacheValue == null) {
                currentSize++;
            } else {
                cache.remove(k);
            }
        } else {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(k, v);
    }

    public V get(K k) {
        V res = cache.get(k);
        if (res != null) {
            cache.remove(k);
            cache.put(k, res);
        }
        return res;
    }


    public static void main(String[] args) {

        LruCache<Integer, Integer> cache01 = new LruCache<>(2);
        assert cache01.get(2) == null;
        cache01.put(2, 6);
        assert cache01.get(1) == null;
        cache01.put(1, 5);
        cache01.put(1, 2);
        assert cache01.get(1) == 2;
        assert cache01.get(2) == 6;


        LruCache<Integer, Integer> cache02 = new LruCache<>(2);
        cache02.put(1, 1);
        cache02.put(2, 2);
        assert cache02.get(1) == 1;

        // evicts key 2
        cache02.put(3, 3);

        assert cache02.get(2) == null;

        // evicts key 1
        cache02.put(4, 4);

        assert cache02.get(1) == null;

        // returns 3
        assert cache02.get(3) == 3;

        assert cache02.get(4) == 4;


        LruCache<Integer, Integer> cache03 = new LruCache<>(2);

        cache03.put(2, 1);
        cache03.put(1, 1);
        cache03.put(2, 3);
        cache03.put(4, 1);
        assert cache03.get(1) == null;
        assert cache03.get(2) == 3;

    }
}

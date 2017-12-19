package com.panxing.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author panxing
 */
public class MemoryManagement {


    /**
     * 调用这个方法后，会报 oom
     */
    private static void oom() {
        List<String> list = new LinkedList<>();
        while (true) {
            list.add(UUID.randomUUID().toString());
        }
    }


    public static void main(String[] args) {
        oom();

    }


}

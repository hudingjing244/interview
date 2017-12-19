package com.panxing.interview;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author panxing
 */
public class MemoryManagement {

    /**
     * 调用这个方法后，会报 oom
     */
    private static void oom() {
        // todo
        throw new NotImplementedException();
    }

    /**
     * 调用这个方法后，会报 stackOverFlow
     */
    private static void stackOverFlow() {
        // todo 
        throw new NotImplementedException();
    }


    public static void main(String[] args) {
//        stackOverFlow();
        oom();
    }


}

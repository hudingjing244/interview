package com.panxing.interview;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author panxing
 * 尽量用剪短的代码 产生 oom 和 Stack Overflow， 当然不要直接 throw 。。。
 * do not do it at home!
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

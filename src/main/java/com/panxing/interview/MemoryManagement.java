package com.panxing.interview;

import com.panxing.interview.util.TodoException;

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
        throw new TodoException();
    }

    /**
     * 调用这个方法后，会报 stackOverFlow
     */
    private static void stackOverFlow() {
        // todo 
        throw new TodoException();
    }


    public static void main(String[] args) {
//        stackOverFlow();
        oom();
    }


}

package com.panxing.interview;

import com.panxing.interview.util.TodoException;

/**
 * 找到比 target 大的最小字符
 * 二分查找题
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 */
public class NextGreatestLetter {

    /**
     * Find Smallest Letter Greater Than Target
     * (提示：用二分法来做)
     */
    private static char nextGreatestLetter(char[] letters, char target) {
        // todo
        throw new TodoException();
    }


    public static void main(String[] args) {

        assert nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a') == 'c';
        assert nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c') == 'f';
        assert nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd') == 'f';
        assert nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g') == 'j';
        assert nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j') == 'c';
        assert nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k') == 'c';

    }


}

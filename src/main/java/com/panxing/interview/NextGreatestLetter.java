package com.panxing.interview;

import com.panxing.interview.util.TodoException;

/**
 * 找到比 target 大的最小字符
 * 二分查找题
 *
 * @author panxing
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

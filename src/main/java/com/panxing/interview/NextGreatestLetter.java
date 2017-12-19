package com.panxing.interview;

/**
 * @author panxing
 */
public class NextGreatestLetter {


    /**
     * Find Smallest Letter Greater Than Target
     * (用二分法来做)
     */
    private static char nextGreatestLetter(char[] letters, char target) {
        return ' ';
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

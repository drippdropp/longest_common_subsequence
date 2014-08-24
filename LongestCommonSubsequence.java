package com.SwynSoft;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequence
{
    public static <E> List<E> _LongestCommonSubsequence(E[] s1, E[] s2)
    {
        // init
        int[][] num = new int[s1.length+1][s2.length+1];


        // populate our data structure, in this case a matrix.
        for (int i = 1; i <= s1.length; i++)
            for (int j = 1; j <= s2.length; j++)
                if (s1[i-1].equals(s2[j-1]))
                    num[i][j] = 1 + num[i-1][j-1];
                else
                    num[i][j] = Math.max(num[i-1][j], num[i][j-1]);

        System.out.println("length of LCS = " + num[s1.length][s2.length]);

        // init
        // s1 is y, s2 is x on the matrix.
        int s1position = s1.length, s2position = s2.length;
        List<E> result = new LinkedList<E>();

        // walk the matrix, adding the elements from the s1/s2 collection to
        // result LinkedList that match our criteria.
        while (s1position != 0 && s2position != 0) {
            // if the elements are the same, then we add the element
            // from s1 to our linkedlist.
            if (s1[s1position-1].equals(s2[s2position-1])) {
                result.add(s1[s1position-1]);
                s1position--;
                s2position--;
            }
            // if the previous element in the row is larger than the element
            // in the same position of the previous row, then we decrement s2position
            // thus continuing on the same row, one element before.
            else if (num[s1position][s2position-1] >= num[s1position][s2position]) {
                s2position--;
            }
            // if the previous element in the row is smaller than the element
            // in the same position of the previous row, then we decrement s1position
            // thus stepping up one row in our matrix, and remaining in the same position of the row.
            else {
                s1position--;
            }
        }

        // Once we have finished walking the matrix, we reverse it.
        Collections.reverse(result);
        return result;
    }


    public static void main (String[] args)
    {
        List<Character> my_result = new LinkedList<Character>();
        String word1 = "notification";
        String word2 = "notefucashon";
        Character[] a_char1 = new Character[word1.length()];
        Character[] a_char2 = new Character[word2.length()];
        for (int i = 0; i < word1.length(); i++)
            a_char1[i] = word1.charAt(i);
        for (int i = 0; i < word2.length(); i++)
            a_char2[i] = word2.charAt(i);

        my_result = LongestCommonSubsequence._LongestCommonSubsequence(a_char1, a_char2);
        for (int i = 0; i < my_result.size(); i++)
            System.out.println(my_result.get(i));
    }

}

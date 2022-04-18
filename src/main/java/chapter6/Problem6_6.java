package chapter6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * This problem is concerned with deleting repeated elements from a sorted array
 * For example if A = {2 , 3 , 5, 5,7 , 11 , 11 , 11, 13} , then after deletion ,
 * A = {2 , 3 , 5 , 7 , 11 , 13 , 0 , 0 , 0}
 * After deletion there are 6 valid entries in A , there are requirements as to
 * the values sorted beyond the last valid element
 *
 * Write a function which takes input a sorted array A and updates
 * A so that all duplicates have been removed and the remaining elements have been
 * shifted left to fill the emptied indices. Return the number of  valid elements in A.
 */
public class Problem6_6 {

    public int removeDuplicates(int[] input)
    {
        int length = input.length ;


        int offset = 0;
        for(int index = 0 ; index < input.length ; index++)
        {
            while(index < input.length-1 && input[index] == input[index+1] )
            {
                index ++;
                offset ++ ;
            }
            input[index-offset] = input[index];
        }

        for(int index = offset-1 ; index >=0 ; index-- )
        {
            input[input.length-1-index] =  0;
        }
        return length - offset ;

    }

    @Test
    public void test()
    {
        int[] input ;
        int[] expected ;
        int length ;

        input = new int[] {2 , 3 , 5, 5,7 , 11 , 11 , 11, 13};
        expected = new int[] {2 ,3 , 5 , 7 , 11 , 13 , 0 , 0 , 0};


        length = removeDuplicates(input);
        assertEquals(6 , length);
        assertArrayEquals(expected , input);

        input = new int[] { 2 ,2 ,2 ,2 ,2};
        expected = new int[] {2 , 0 , 0 , 0 , 0};
        length = removeDuplicates(input);
        assertEquals(1 , length);
        assertArrayEquals(expected , input);

    }

}

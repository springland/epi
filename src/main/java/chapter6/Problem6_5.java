package chapter6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *  Implement a function which takes as input an  array A of integers
 *  and an integer k and update A so that all occurrences of k have been removed
 *  and the remaining elements have been shifted left to fill the emptied indices
 *  There are no requirements as to the values stored beyond the last valid element
 *
 *  A = {5 , 3 , 7 , 11 , 2 , 3, 13, 5 , 7}  k = 3
 *  then {5 , 7 , 11 , 2 , 13 ,5 , 7 , Integer.MIN_VALUE , Interger.MIN_VALUE }
 *  and the return value is 7 ( the last value )
 */
public class Problem6_5 {

    public int remove(int[] array , int k)
    {
        int offset = 0 ;

        for(int index = 0 ; index < array.length ; index++)
        {
            while(index < array.length && array[index] == k)
            {
                index++;
                offset -- ;
            }
            if(index < array.length) {
                array[index + offset] = array[index];
            }
        }

        for(int index = 0 ; index > offset ; index--)
        {
            array[array.length-1+index] = Integer.MIN_VALUE;
        }

        return -array.length == offset ? Integer.MIN_VALUE :array[array.length-1 + offset] ;
    }

    @Test
    public void test()
    {
        int[]  input = new int[] {5 , 3 , 7 , 11 , 2 , 3 , 13 , 5 , 7};
        int[]  expected = new int[] {5 , 7 , 11 , 2 ,  13 , 5 , 7 , Integer.MIN_VALUE , Integer.MIN_VALUE};

        int lastElement =  0 ;
        lastElement = remove(input , 3);
        assertEquals(lastElement , 7);
        assertArrayEquals(expected , input  );

        input = new int[] { 3 ,3  ,3 , 3};
        expected = new int [] {Integer.MIN_VALUE , Integer.MIN_VALUE , Integer.MIN_VALUE , Integer.MIN_VALUE };
        lastElement = remove(input , 3);
        assertEquals(lastElement , Integer.MIN_VALUE);
        assertArrayEquals(expected , input  );

    }
}

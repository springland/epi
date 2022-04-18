package chapter6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *  Let A be an array. Design an O(n) algorithm to find the smallest positive x
 *  such that  x <> A[i] for any i. You do not need to preserve the contents of  A
 *
 *   { 2 ,3 ,4 , 5} -> 1
 *   {1 , 2 ,3 , 6 , 5 , 8} -> 4
 *   {Integer.MAX_VALUE } -> 1
 *   {1 , 2 , 3 , 4 , 5} ->6
 *
 *
 */
public class Problem6_7 {

    // The missing is between 1 and n+1 , n is the length of data

    public int findFirstMissingValue(int[] data)
    {
        boolean[] appears = new boolean[data.length+2];

        for(int index=0 ; index < data.length ; index++)
        {
            if(data[index] <= data.length+1)
            {
                appears[data[index]] = true ;
            }
        }

        for(int index = 1 ; index < appears.length ; index++)
        {
            if(appears[index] == false)
            {
                return index ;
            }
        }
        throw new IllegalArgumentException("Should never be here");
    }

    @Test
    public void test()
    {
        int[] data = new int[] {1 ,2 , 3, 4};
        assertEquals(5 , findFirstMissingValue(data));

        data = new int[] { 2 , 1 , 3 , 5};
        assertEquals(4 , findFirstMissingValue(data));

        data = new int[] {Integer.MAX_VALUE };
        assertEquals(1 , findFirstMissingValue(data));

        data = new int[] {2 , 3 , 6};
        assertEquals(1 , findFirstMissingValue(data));

    }
}

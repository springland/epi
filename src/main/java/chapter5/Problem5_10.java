package chapter5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Write a function which takes an integer K and returns the integer
 * corresponding to the digits of K in reverse order
 */
public class Problem5_10 {
    public int reverse(int num)
    {
        if(num == 0)
        {
            return 0 ;
        }

        int sign = num > 0 ? 1:-1;
        num = num *sign ;
        int reversed = 0 ;
        while(num > 0)
        {
            reversed = reversed *10 + num %10;
            num = num /10 ;
        }
        return reversed*sign ;
    }

    @Test
    public void test()
    {
        assertEquals(123  , reverse(321));
        assertEquals(-123  , reverse(-321));
    }
}

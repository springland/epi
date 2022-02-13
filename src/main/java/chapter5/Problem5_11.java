package chapter5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Write a function that takes an integer and determine if that integer's
 * representation as a decimal string is palindrome
 *
 */
public class Problem5_11 {
    public boolean isPalindrome(int num)
    {
        if(num < 0)
        {
            return false ;
        }
        if(num == 0)
        {
            return true ;
        }


        int reverse = 0;
        int temp = num ;
        while(temp > 0)
        {
            reverse = reverse *10 +temp%10 ;
            temp = temp/10;
        }

        return reverse - num == 0;
    }

    @Test
    public void test()
    {
        assertTrue(isPalindrome(0));
        assertTrue(isPalindrome(1));
        assertTrue(isPalindrome(7));
        assertTrue(isPalindrome(11));
        assertTrue(isPalindrome(121));
        assertTrue(isPalindrome(333));
        assertTrue(isPalindrome(2147447412));

        assertFalse(isPalindrome(-1));
        assertFalse(isPalindrome(12));
        assertFalse(isPalindrome(100));
        assertFalse(isPalindrome(2147483647));
    }
}

package chapter5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The greatest common divisor GCD of positive integer x and y are the largest
 * integer d such that x % d == 0 and y % d == 0
 *
 *
 * Design an efficient algorithm for computing the GCD of two numbers
 * without using multiplication , division or the modulus operators
 *
 */
public class Problem5_15 {

    public int euclidGCD(int num1 , int num2)
    {
        // https://en.wikipedia.org/wiki/Greatest_common_divisor

        //  a> b , gcd(a , b ) = gcd(a-b , b)
        //
        //

        if(num1 == num2)
        {
            return num1 ;
        }
        if(num1 > num2)
        {
            return euclidGCD(num1 - num2 , num2);
        }
        else
        {
            return euclidGCD(num2 - num1 , num1);
        }


    }

    @Test
    public void testEuclidGCD()
    {
        assertEquals(6 , euclidGCD(48 , 18));
    }


    public  int euclideanGCD(int num1 , int num2)
    {
        if(num1 != 0 && num2 != 0)
        {
            if ( num1 > num2 )
            {
                return euclideanGCD(num2 , num1 % num2);
            }
            else
            {
                return euclideanGCD(num1 , num1 % num2);
            }
        }

        return num1 != 0 ? num1 : num2 ;

    }

    @Test
    public void testEuclideanGCD()
    {
        assertEquals(6 , euclideanGCD(48 , 18));
    }
}

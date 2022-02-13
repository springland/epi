package chapter5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given two positive integers x and y , how do you compute x/y if
 * the only operation you can use  are addition ,subtraction and shifting?
 */
public class Problem5_6 {

    public int division(int x , int y)
    {
        if(x < y)
        {
            return 0 ;
        }
        // To make it simple I am making an assumption that x can be divided by y
        // for example (15 , 5)  or (27 , 9) , it can happen (27 , 4)

        int result = 0;
        int remainder = x ;
        while(remainder>= y)
        {
            int temp = y;
            int index = 0;
            while(temp <= remainder)
            {
                temp <<=1;
                index++;
            }

            // shift 1 bit back
            index--;
            remainder -= temp >> 1;

            result += 1 << index ;
        }

        return result ;

    }

    @Test
    public void testDivision()
    {
        assertEquals(0 , division( 0  , 1) );
        assertEquals(1 , division( 1  , 1) );
        assertEquals(4 , division( 8  , 2) );
        assertEquals(7 , division( 63  , 9) );
        assertEquals(1 , division( 5  , 3) );
        assertEquals(3 , division( 15  , 4) );
        assertEquals(60 , division( 180  , 3) );
    }
}

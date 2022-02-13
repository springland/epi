package chapter5;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Often the processors used in embedded system do not have a hardware multiplier
 * A program that needs to perform multiplication must do so explicitly
 *
 *
 * Write a function that multiplies two unsigned positive integer.
 * The only operation you are allowed to use are assignment and the bitwise operation
 * i.e. >> , << , | , & , ~ ,  ^ . You may use loops , conditionals and functions that write yourself
 */
public class Problem5_5 {

    public int multiple(int val1 , int val2)
    {

        // multiply by power of 2 can be done by bit shift directly
        if ( val1 == 0 || val2 == 0)
        {
            return 0 ;
        }
        int total = 0 ;

        int bitMask = 0x00000001 ;
        for(int index = 0  ; index < 32 ; index++)
        {
            if((bitMask & val2) == 1)
            {
                int value = val1 << index ;
                total = add(total , value);
            }
            val2 >>= 1;
        }

        return total ;

    }

    public int add(int val1 , int val2)
    {
        /*
            0  0    1      0    1      1     0    1     0

            0  0    1      1    0      1     1    0     0
         =

            0  1   <-1   <- 0 <- 0   <- 1     1    1    0

         */


        int carry = 0 ;
        int bitMask = 0x00000001;
        int bitVal1  ;
        int bitVal2  ;

        int total = 0;
        for(int index = 0 ; index < 32 ; index ++)
        {
             bitVal1 = bitMask & val1 ;
             bitVal2 = bitMask & val2 ;

             int result = addBit(bitVal1 , bitVal2 ,carry);
             int bit = result & 0x00000001;
             carry = result >> 16;
             total |= bit << index ;

             val1 >>= 1 ;
             val2 >>= 1 ;
        }


        return total ;
    }

    /**
     * Return a integer , lower half is result , higher half is carry
     */
    protected int addBit(int bit1 , int bit2 , int carry)
    {
        int bit ;
        int carryForward ;
        if(bit1 == 0)
        {
            if(bit2 == 0)
            {
                // 0 , 0
                bit = carry ;
                carryForward = 0;
            }
            else
            {
                //  0, 1
                if(carry == 1)
                {
                    bit = 0 ;
                    carryForward = 1;
                }
                else
                {
                    bit = 1 ;
                    carryForward = 0;
                }
            }
        }
        else
        {
            // 1 , 0
            if(bit2 == 0)
            {
                if(carry == 1)
                {
                    bit = 0 ;
                    carryForward = 1;
                }
                else
                {
                    bit = 1;
                    carryForward = 0;
                }

            }
            else
            {
                // 1 , 1
                if(carry == 1) {
                    bit = 1;
                    carryForward = 1;
                }
                else
                {
                    bit = 0;
                    carryForward = 1;
                }
            }
        }
        carryForward <<=16;
        return carryForward | bit ;

    }

    @Test
    public void testAddBit()
    {
       // assertEquals(  0x00000000,  addBit(0 , 0 , 0));
       // assertEquals(  0x00000001,  addBit(0 , 0 , 1));
        assertEquals(  0x00000001,  addBit(0 , 1 , 0));
        assertEquals(  0x00010000,  addBit(0 , 1 , 1));
        assertEquals(  0x00000001,  addBit(1 , 0 , 0));
        assertEquals(  0x00010000,  addBit(1 , 0 , 1));
        assertEquals(  0x00010000,  addBit(1 , 1 , 0));
        assertEquals(  0x00010001,  addBit(1 , 1 , 1));

    }

    @Test
    public void testAdd()
    {
        assertEquals(5 , add(2 , 3));
        assertEquals(15 , add(7 , 8));
        assertEquals(340 , add(103 , 237));
    }

    @Test
    public void testMultiply()
    {
        assertEquals(6 , multiple(2 , 3));
        assertEquals(30 , multiple(5 , 6));

        for( int outerIndex = 0 ; outerIndex < 1000; outerIndex ++)
        {
            for(int innerIndex = 0 ; innerIndex < 1000 ; innerIndex++)
            {
                assertEquals(innerIndex * outerIndex , multiple(innerIndex , outerIndex));
            }

        }
    }


}

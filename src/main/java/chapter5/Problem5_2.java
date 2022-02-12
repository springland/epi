package chapter5;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * A 64 bits integer can be viewed as an arry of 64 bits, with the bit
 * at index 0 corresponding to the least significiant bit(LSB)
 * and the bit at index 63 corresponding to the most significiant bit(MSB).
 * Implement code that takes as input a 64-bit integer x and swap the bits at indices i and j
 */
public class Problem5_2 {

    /*
        Use int to simplify it
     */

    public int swapBits(int srcValue , int i , int j)
    {
        // get  bit i
        // get the bitmask for bit j by using bit i srcValue
        int targetValue = srcValue ;

        int bitIValue = getBit(srcValue , i);
        int bitJMask = getBitMask(bitIValue , j);
        if(bitIValue == 0)
        {
            targetValue &= bitJMask ;
        }
        else
        {
            targetValue |= bitJMask ;
        }
        // get  bit j
        // get the bitmask for bit i by using bit j srcValue
        int bitJValue = getBit(srcValue , j);
        int bitIMask = getBitMask(bitJValue , i);
        if(bitJValue == 0)
        {
            targetValue &= bitIMask ;
        }
        else
        {
            targetValue |= bitIMask ;
        }

        return targetValue ;
    }

    protected int getBit(int value ,int bitIndex)
    {

        value >>= bitIndex ;

        return value & 0x0001 ;
    }

    /**
     * if bitValue is 0 return 111101111 for and operation
     * if bitValue is 1 return 000010000 for or operation
     * @param bitValue
     * @param bitIndex
     * @return
     */
    protected int getBitMask(int bitValue , int bitIndex)
    {
        int bitMask = 1 ;
        bitMask <<=bitIndex ;


        return bitValue == 1 ? bitMask : ~bitMask ;
    }

    @Test
    public void testGetBit()
    {
        //0b 1000 0000 0010 0000 0000 0000 0000 1111
        int value = 0b10000000001000000000000000001111;
        assertEquals(getBit(value , 0) , 1);
        assertEquals(getBit(value , 1) , 1);
        assertEquals(getBit(value , 2) , 1);
        assertEquals(getBit(value , 3) , 1);
        assertEquals(getBit(value , 4) , 0);
        assertEquals(getBit(value , 20) , 0);
        assertEquals(getBit(value , 21) , 1);
        assertEquals(getBit(value , 30) , 0);
        assertEquals(getBit(value , 31) , 1);
    }

    @Test
    public void testGetBitMask()
    {
        //0b 0000 0000 0000 0000 0000 0000 0000 1000
        assertEquals(getBitMask(1 , 3) ,0b00000000000000000000000000001000 );

        assertEquals(getBitMask(0 , 3) ,0b11111111111111111111111111110111 );
    }

    @Test
    public void testSwapBits()
    {
        //0b 0000 0000 0000 0000 0000 0000 0000 1000
        int srcValue = 0b00000000000000000000000000001000;

        //0b 0000 0000 0000 0000 0100 0000 0000 0000
        int swaped = swapBits(srcValue , 3 , 14);
        assertEquals(0b00000000000000000100000000000000, swaped);
    }
}

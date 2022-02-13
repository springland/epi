package chapter5;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Write a function that takes a integer x and reeturns a integer consisting of the bits of x in
 * reverse order
 */
public class Problem5_3 {

    public int reverseBits(int srcValue)
    {
        int reversedBits = 0 ;
        int bitMask = 0x0001 ;
        int bitValue ;
        for( int index = 0  ; index < 31 ; index++)
        {
            bitValue = srcValue & bitMask ;
            reversedBits |= bitValue ;

            srcValue >>= 1 ;
            reversedBits <<= 1;
        }
        bitValue = srcValue & bitMask ;
        reversedBits |= bitValue ;

        return reversedBits ;
    }

    @Test
    public void testReverseBits()
    {
       // 0x00000001  -> 0x80000000

       assertEquals(0x80000000 , reverseBits(0x0001));

       // 0b1000 1111 0101 1000 0111 1011 1000 1100
       // 0b0011 0001 1101 1110 0001 1010 1111 0001
        assertEquals(0b00110001110111100001101011110001 , reverseBits(0b10001111010110000111101110001100));
    }
}

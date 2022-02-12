package chapter5;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * The Pairity of a sequence of bits is 1 if the number of 1s in sequence is odd
 * otherwise it is 0 . Parity checks are used to detect signle bit errors in data storage
 * and communication.
 *
 * How would you go about computing the parity of a very large 64-bit nonnegative intergers?
 */
public class Problem5_1 {

    public static int calculateParity(long num)
    {
        int count = 0 ;
        long bitMask = 0x0000000000000001L;

        for (int index = 0 ; index < 64 ; index++)
        {
            count += num & bitMask ;
            num >>= 1;
        }

        return count%2 ;

    }


    @Test
    public void test()
    {
        int parity = calculateParity(0x0000000000000001);
        assertEquals(parity , 1);

        parity = calculateParity(0x0000000000000003);
        assertEquals(parity , 0);

        parity = calculateParity(0x0000000000030003);
        assertEquals(parity , 0);

        parity = calculateParity(0x0000005000030003L);
        assertEquals(parity , 0);

        parity = calculateParity(0x0000405000030003L);
        assertEquals(parity , 1);

    }
}

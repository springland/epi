package chapter5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Write a function that converts Excel column ids to the corresponding integer
 * , With "A" to 1 . The function signature is int ssDecodColID(String). You may
 * ignore error conditions, such as col contains character
 * out side of [A, Z]. How would you test your code?
 */
public class Problem5_9 {

    public int ssDecodeColID(String colName)
    {
        final int step = 26 ;
        int col = 0 ;
        for(int index = 0 ; index < colName.length() ; index++)
        {
            col = col * 26 + colName.charAt(index) - 'A'+1;
        }
        return col ;
    }

    @Test
    public void test()
    {
        //https://bettersolutions.com/excel/rows-columns/letters-to-numbers.htm
        assertEquals(ssDecodeColID("A") , 1);
        assertEquals(ssDecodeColID("Z") , 26);
        assertEquals(ssDecodeColID("AZ") , 26+26);
        assertEquals(ssDecodeColID("CZ") , 3*26+26);
        assertEquals(ssDecodeColID("DF") , 110);
        //https://exceljet.net/formula/convert-column-letter-to-number
        assertEquals(ssDecodeColID("CUZ") , 2600);
        assertEquals(ssDecodeColID("NTP") , 10000);
    }
}

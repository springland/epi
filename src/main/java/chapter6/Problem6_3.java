package chapter6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 *  Write a function that takes two strings representing integers
 *  and return an integer representing their product
 *  for example , since 193707721 X -761838257287 = -147573952589676412927
 *  if the inputs are "193707721" and "-761838257287"
 *  your function should return "-147573952589676412927"
 */
public class Problem6_3 {

    public char[] multiple(char[] num1 , char[] num2)
    {
        boolean negative = false ;

        int num1StartIndex = 0;
        if(num1[0] == '-')
        {
            negative = ! negative;
            num1StartIndex = 1;
        }

        int num2StartIndex = 0 ;
        if(num2[0] == '-')
        {
            negative = !negative;
            num2StartIndex = 1 ;
        }

        int[] data = new int[100];
        int dataIndex = 0 ;
        for(int num1Index = num1.length-1 ; num1Index >= num1StartIndex ;num1Index -- )
        {
            int carry = 0;
            for(int num2Index = num2.length-1 ; num2Index >= num2StartIndex ; num2Index -- )
            {
                int value1 = num1[num1Index] - '0' ;
                int value2 = num2[num2Index] - '0' ;

                dataIndex = num1.length-1 -num1Index   + num2.length -1 - num2Index  ;
                int value = (value1 * value2 + carry +  data[dataIndex] ) %10;
                carry = (value1 * value2 + carry +  data[dataIndex] ) /10;

                data[dataIndex] =  value;
            }

            data[dataIndex+1] += carry ;
        }

        int lastDigitIndex = data.length-1 ;

        while(data[lastDigitIndex] == 0)
        {
            lastDigitIndex -- ;
        }

        if(negative)
        {
            lastDigitIndex ++;
        }

        char[] result = new char[lastDigitIndex+1];
        int startIndex = 0;
        if(negative)
        {
            result[0] = '-';
            startIndex = 1;
        }

        for(int index = startIndex ; index <= lastDigitIndex ; index++)
        {
            result[index] = (char)(data[lastDigitIndex - index] + '0');
        }


        return result ;
    }


    @Test
    public void test()
    {
        char[] num1 = new char[] {'1' , '2'};
        char[] num2 = new char[] {'2' , '3' , '4'};
        char[] result = new char[] {'2' , '8' , '0' , '8'};

        assertArrayEquals(result , multiple(num1 , num2));

        num1 = new char[] {'-' , '1' , '2'};
        result = new char[] {'-' , '2' , '8' , '0' , '8'};
        assertArrayEquals(result , multiple(num1 , num2));

        num1 = new char[] {'1' , '2'};
        num2 = new char[] {'-' , '2' , '3' , '4'};
        result = new char[] {'-' , '2' , '8' , '0' , '8'};
        assertArrayEquals(result , multiple(num1 , num2));


        num1 = new char[] {'9' , '9' , '9'};
        num2 = new char[] {  '9' , '9' , '9'};
        result = new char[] {'9' , '9' , '8' , '0' , '0' , '1'};
        assertArrayEquals(result , multiple(num1 , num2));


    }
}

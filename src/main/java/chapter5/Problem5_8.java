package chapter5;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Write a function to perform base conversion. Specifically, the input is an
 * integer base b1 , a string s , representing an integer x in base b1 and another
 * integer base b2 ; the output is the string representing the integer in base b2
 */
public class Problem5_8 {

    enum FORMAT {
        BINARY(2) {

        },
        OCTAL(8) {

        },
        DECIMAL(10) {

        },
        HEX(16){

            @Override
            public int parse(String valueString) {
                int value = 0;
                for(int index = 0 ; index < valueString.length() ; index++)
                {
                    int charValue ;
                    if(valueString.charAt(index) >= '0' && valueString.charAt(index) <= '9')
                    {
                        charValue = valueString.charAt(index) - '0';
                    }
                    else
                    {
                        charValue = valueString.charAt(index) - 'A' + 10;
                    }

                    value = value * base + charValue ;
                }
                return value;
            }

            @Override
            public String format(int value) {
                char[] chars = new char[] {'0' , '1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9' , 'A' , 'B' , 'C' , 'D' , 'E' , 'F'};
                StringBuilder builder = new StringBuilder();

                if(value == 0)
                {
                    return "0";
                }

                while(value > 0)
                {
                    int remainder = value % base ;
                    builder.append(chars[remainder]);
                    value /= base ;
                }

                builder.reverse() ;
                return builder.toString();
            }
        } ;

        FORMAT(int base) {
            this.base = base ;
        }


        public int parse(String valueString) {
            int value = 0;
            for(int index = 0 ; index < valueString.length() ; index++)
            {
                value = value * this.base + valueString.charAt(index)- '0';
            }

            return value;
        }

        public  String format(int value)
        {
            StringBuilder builder = new StringBuilder();

            if(value == 0)
            {
                return "0";
            }
            while(value > 0)
            {
                builder.append(value % base);
                value = value /base ;
            }
            builder.reverse();
            return builder.toString();
        }

        protected int base ;

        public static  FORMAT of(int base)
        {
            for( FORMAT fmt : values())
            {
                if (fmt.base == base)
                {
                    return fmt ;
                }
            }
            throw new IllegalArgumentException("Unknown base " + base);
        }
    }


    public String convert(int b1 , int b2 , String value)
    {
        FORMAT  fmt1 = FORMAT.of(b1);
        FORMAT fmt2 = FORMAT.of(b2);
        int intValue = fmt1.parse(value);
        return fmt2.format(intValue);

    }

    @Test
    public void testFormat()
    {
        for(int index = 0 ; index < 100 ; index++)
        {
            assertEquals(FORMAT.BINARY.format(index) , Integer.toBinaryString(index));
            assertEquals(FORMAT.OCTAL.format(index) , Integer.toOctalString(index));
            assertEquals(FORMAT.DECIMAL.format(index) , Integer.toString(index));
            assertEquals(FORMAT.HEX.format(index) , Integer.toHexString(index).toUpperCase());
        }
    }

    @Test
    public void testParse()
    {

        for(int index = 0 ; index < 100 ; index++)
        {
            assertEquals(index , FORMAT.BINARY.parse(Integer.toBinaryString(index)));
            assertEquals(index , FORMAT.OCTAL.parse(Integer.toOctalString(index)));
            assertEquals(index , FORMAT.DECIMAL.parse(Integer.toString(index)));
            assertEquals(index , FORMAT.HEX.parse(Integer.toHexString(index).toUpperCase()));
        }
    }

    @Test
    public void test()
    {
        for(int index = 0 ; index < 100 ; index++)
        {
            assertEquals(Integer.toHexString(index).toUpperCase() , convert(8 , 16 , Integer.toOctalString(index)));
            assertEquals(Integer.toHexString(index).toUpperCase() , convert(2 , 16 , Integer.toBinaryString(index)));
            assertEquals(Integer.toHexString(index).toUpperCase() , convert(10 , 16 , Integer.toString(index)));
        }

    }
}

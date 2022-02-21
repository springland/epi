package chapter6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Write a funciton which takea as input an array A of digits
 * encoding a decimal number D and update A to represent the number D+1
 * for example A = {1 , 2 ,3} then you should update A to {1  , 2 , 4}
 */
public class Problem6_2 {

    public int[] increment(int[] num)
    {
        int carry = 1 ;
        int data[] ;
        for(int index = num.length-1 ; index >= 0 ; index--)
        {
            carry = (carry + num[index])/10;

        }
        if(carry == 0)
        {
            data = new int[num.length];
        }
        else
        {
            data = new int[num.length+1];
        }

        carry = 1;
        int dataIndex = data.length-1;
        for(int index = num.length-1 ; index >= 0 ;index --)
        {
            data[dataIndex] = (num[index] + carry) %10 ;
            carry = (num[index] + carry) /10;
            dataIndex -- ;
        }

        if(carry == 1)
        {
            data[dataIndex] = carry ;
        }

        return data ;
    }

    @Test
    public void test()
    {
        int [] expected = new int [] { 1 , 2, 4};
        int [] data = new int[] { 1 , 2 , 3};
        assertArrayEquals(expected , increment(data));

        data = new int[] { 9 , 9 , 9};
        expected = new int [] { 1 , 0 , 0 , 0};
        assertArrayEquals(expected , increment(data));
    }


}

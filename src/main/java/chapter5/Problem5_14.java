package chapter5;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Five hundred closed doors along a corridor are numbered from 1 to 500
 * A person walks through the corridor and opens each door , another
 * person walks through the corridor and close every alternate door
 * Continuing in this matter , the i-th person comes and toggles the position of every i-th door
 * starting from door 1
 *
 * Which doors are open after the 500th person has walked through?
 */
public class Problem5_14 {

    /*
    This is a question that if a number can be divided by the factor smaller than it

    The simplest solution is to iterate from 1 to n  then toggle each door , the complexity is O(n^2)

    */

    public boolean[] toogle1(boolean[] doors)
    {

        // O(n^2)

        for(int index = 0 ; index < doors.length ; index++)
        {
            for(int inner = index ; inner < doors.length ; inner += index+1)
            {
                doors[inner] = !doors[inner];
            }
        }

        return doors;
    }

    public boolean[] toogle2(boolean[] doors)
    {
        // O(nlog(n))

        // divide and concur

        doors[0] = true ;

        for(int index = 1 ; index < doors.length ; index++)
        {
            int divisorCount = divisorsCount( index+1 , 2 , (index+1)/2);
            divisorCount += 2;
            doors[index] = divisorCount%2 == 1;
        }
        return doors ;
    }

    protected int divisorsCount(int value , int start , int end)
    {
        if(end < start)
        {
            return 0 ;
        }
        if(start == end)
        {
            return value % start == 0 ? 1: 0;
        }

        int middle = (start + end)/2;
        int left = divisorsCount(value , start , middle);
        int right = divisorsCount(value , middle+1 , end);

        return left + right ;


    }

    public boolean[] toogle3(boolean[] doors)
    {
            /*


        it seems to have relationship with how the number is represented in binary format ,
        512 = 10 0000 0000

         1 :  0001      ( 1 )
         2 :  0010      (1 , 2)
         3 :  0011      ( 1 , 3)
         4 :  0100     ( 1 , 2 , 4)
         5 :  0101     ( 1 , 5)
         6 :  0110     ( 1 , 2 , 3 ,6)
         7 :  0111     ( 1 , 7)
         8 :  1000     ( 1 , 2 , 4 , 8)
         9 : 1001     ( 1 , 3 , 9 )
         10 : 1010    ( 1 , 2 , 5 , 10)
         11 : 1011     (1  ,11)
         12: 1100     (1 , 2 , 3 , 4 , 6 , 12)
         13: 1101     ( 1 , 13)
         14: 1110     ( 1 , 2 , 7 , 14)
         15 : 1111    (1 , 3 , 5 , 15)
         16 : 1 0000  ( 1 , 2 , 4 , 8 , 16)
     */

        // try to get a O(n) algorithm
        return doors ;
    }


    @Test
    public void testToggle1()
    {
        boolean[] raw = new boolean[16];
        boolean[] expected = new boolean[] {true , false , false , true , false ,false , false , false , true , false , false , false , false , false , false , true};

        assertArrayEquals(expected , toogle1(raw));
    }


    @Test
    public void testToggle2()
    {
        boolean[] raw = new boolean[16];
        boolean[] expected = new boolean[] {true , false , false , true , false ,false , false , false , true , false , false , false , false , false , false , true};

        assertArrayEquals(expected , toogle2(raw));

    }
}

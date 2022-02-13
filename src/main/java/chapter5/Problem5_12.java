package chapter5;

import org.junit.Test;

/**
 * How would you implement a random number generator that generates a random interger in [a , b]
 * given a random number generator that produces either  zero or one with equal probability?
 * All of the generated number should have equal probability
 * What is the run time of your algorithm
 */
public class Problem5_12 {

    protected int random()
    {
        return Math.random()>= 0.5? 1:0;

    }




    public int random(int a , int b)
    {

        // if all of the randoms are 1 it is b
        // if all of the randoms are 0 it is a
        // there is an issue here , suppose a = 1 and b =3 , the below algorithm can generate values 0 ,1 , 2 , 3
        // however the candidate values are 1 ,2 , 3

        int total = 0;

        for(int index = a ; index < b; index++)
        {
            total += random();
        }
        return total + a;
    }

    @Test
    public void test()
    {
        int[] hitCount = new int[10];
        int size = 1000000;
        int a = 1;
        int b = 3;
        for(int index = 0 ; index < size ; index++)
        {
            int num = random(a , b);
            hitCount[num] ++;
        }

        for(int index = a ; index <= b ; index++)
        {
            System.out.println( String.format(" value %d , hit %f" , index , hitCount[index]/(double)size));
        }
    }
}

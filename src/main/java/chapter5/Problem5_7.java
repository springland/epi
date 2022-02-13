package chapter5;

/**
 * Write a function that takes a double x and an integer y to computer x power of y
 * You can ignore the overflow and underflow. The time complexity should be O(n)
 * n is the number of bits in y. Assume primitive operation takes constant time
 */
public class Problem5_7 {


    public double power(double x , int y)
    {

        // IEEE-754 format https://en.wikipedia.org/wiki/Double-precision_floating-point_format

        // the first bit is sign
        // the next 11 bits is  exponent , let's call it a
        // the next 52 bits is fraction , let's call it b
        //  y =(1+b) * 2 power( a - 1023)
        //   y ^x = (1+b)^x  * 2^(a-1023)^x
        //
        return x ;
    }
}

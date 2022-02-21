package chapter5;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Let R and S be xy-aligned rectangles in Cartesian plane. Write a
 * function which tests if R and S have a nonempty intersection. If the intersection
 * is noempty , return the rectangle formed by their intersection
 *
 * A Rectangle is  charactized by its left-most lower point (Rx , Ry)  , Width Rw , Height Rh
 */
public class Problem5_13 {

    class Rectangle {
        int x , y , width , height ;

        public Rectangle(int x , int y , int width , int height)
        {
            this.x = x ;
            this.y = y ;
            this.width = width ;
            this.height = height ;
        }

        public String toString()
        {
            StringBuilder builder = new StringBuilder();
            builder.append("x=").append(this.x).append(" y=").append(this.y);
            builder.append(" width=").append(this.width).append(" height=").append(this.height);
            return builder.toString();
        }

        public boolean equals(Object o)
        {
            if(this == o)
            {
                return true ;
            }
            if (o instanceof Rectangle) {
                Rectangle r = (Rectangle) o ;

                return r.x == this.x && r.y == this.y && r.width == this.width && r.height == this.height;
            }
            return false ;
        }
        public Rectangle intersect(Rectangle r)
        {
            if(this.x < r.x)
            {
                if(this.y < r.y)
                {
                    /*
                                        (x2 , y2)
                          (x1 , y1)
                     */
                    if(this.x + width > r.x && this.y + height > r.y)
                    {
                        return new Rectangle(r.x , r.y , width - r.x + this.x  , height -r.y + this.y);
                    }
                    else
                    {
                        return null ;
                    }
                }
                else
                {
                         /*
                            (x1 , y1)
                                        (x2 , y2)

                         */

                    if(this.x + width > r.x && r.y + r.height > this.y)
                    {
                        return new Rectangle(r.x , this.y , x + width  - r.x  , r.y + r.height - this.y);
                    }
                    else
                    {
                        return null ;
                    }
                }
            }
            else
            {
                if( this.y < r.y)
                {
                    /*
                       (x2 , y2)
                                (x1 , y1)
                     */

                    if(r.x + r.width > x && this.y + this.height > r.y)
                    {
                        return new Rectangle(x , r.y , r.x + r.width -x , this.y + this.height - r.y);
                    }
                    else
                    {
                        return null ;
                    }
                }
                else
                {
                    /*
                                  (x1 , y1)
                        (x2 , y2)
                     */


                    if(r.x + r.width > this.x && r.y + r.height > this.y )
                    {
                        return new Rectangle(this.x , this.y , r.x + r.width - this.x , r.y + r.height - this.y);
                    }
                    else
                    {
                        return null ;
                    }
                }
            }
        }
    }

    public Rectangle intersect(Rectangle r1 , Rectangle r2)
    {
        return r1.intersect(r2);
    }


    @Test
    public void test()
    {
        Rectangle r1 , r2 ;
        Rectangle intersection  ;
        r1 = new Rectangle( 0 , 0 , 10 , 10);
        r2 = new Rectangle( 5 , 5 , 10 , 10);
        intersection = new Rectangle(5 , 5   , 5 , 5);
        assertEquals(intersection , intersect(r1 , r2));

        assertEquals(intersection , intersect(r2 , r1));

        r2 = new Rectangle(10 , 10 , 2 , 2);
        assertNull(intersect(r1 , r2));
        assertNull(intersect(r2 , r1));

        r1 = new Rectangle(5 , 0 , 10 , 10);
        r2 = new Rectangle(0 , 5 , 10 , 10);
        assertEquals(intersection , intersect(r1 , r2));
        assertEquals(intersection , intersect(r2 , r1));


        r2 = new Rectangle(0 , 5 , 2 , 2);
        assertNull(intersect(r1 , r2));
        assertNull(intersect(r2 , r1));
    }
}

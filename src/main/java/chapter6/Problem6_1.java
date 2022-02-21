package chapter6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Write a function that takes an array A of the length n and an index i
 * into A , and rearrange the elements such that akk elements less than A[i]
 * appears first , followed by elements equals to A[i]
 * followed by  elements greater than A[i]
 *
 * Your algoritmh should have O(1) space complexity and O(n) time complexity
 */
public class Problem6_1 {

    public int[] sort(int[] nums , int index)
    {
        // like dutch flag

        int target = nums[index];

        int beginIndex = 0 ;
        int endIndex = nums.length -1 ;
        int currentIndex = 0;

        while(nums[beginIndex] < target && beginIndex <= endIndex)
        {
            beginIndex ++ ;
        }

        while(nums[endIndex] > target && endIndex >= beginIndex)
        {
            endIndex -- ;
        }
        currentIndex = beginIndex ;

        while(currentIndex <= endIndex)
        {
            if(nums[currentIndex] < target)
            {
                int temp = nums[currentIndex] ;
                nums[currentIndex] = nums[beginIndex];
                nums[beginIndex] = temp ;
                beginIndex ++;
                currentIndex++;
            }
            else if (nums[currentIndex] == target)
            {
                currentIndex ++ ;
            }
            else
            {
                int temp = nums[currentIndex] ;
                nums[currentIndex] = nums[endIndex];
                nums[endIndex] = temp ;
                endIndex --;
            }
        }
        return nums ;
    }

    @Test
    public void test()
    {
        int[] data = new int[] { 1  ,2 ,3 ,4 ,5 };
        int[] expected = new int [] { 1 ,2 ,3, 4 , 5};
        assertArrayEquals(expected , sort(data , 2));

        data = new int[] { 3 , 5 , 7 , 2 , 1  ,2 ,3 ,4 ,5 } ;
        sort(data , 6);
        printArray(data);
        verify(data , 3);



    }

    protected void printArray(int data[])
    {
        for(int index = 0 ; index < data.length ; index++)
        {
            System.out.print(data[index] + ",");
        }
        System.out.println();
    }
    protected void verify(int[] data , int pivot)
    {

        int state = 0 ;
        for(int index = 0 ; index < data.length ; index++)
        {
            if(data[index] < pivot)
            {
                if(state != 0)
                {
                    throw new IllegalStateException(" found number less than pivot in state " + state);
                }
            }
            else if(data[index] == pivot)
            {
                if(state == 0)
                {
                    state = 1 ;
                }
                if(state != 1)
                {
                    throw new IllegalStateException(" found number less than pivot in state " + state);
                }
            }
            else {
                state = 2;
            }
        }
    }

}

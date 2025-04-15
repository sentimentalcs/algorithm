package sort;

import java.util.Random;

public class Question76 {

    public static void main(String[] args)
    {
        int[] arr = {3,1,2,4,5,6,6};

        int result = new Question76().findKthLargeTarget(arr , 4);
        System.out.println(result);
    }

    /**
     * 题目：请从一个乱序数组中找出第 k 大的数字。例如，数组
     * [3, 1, 2, 4, 5,  5, 6]中第 3 大的数字是 5
     * @param arrs
     * @return
     */
    public int findKthLargeTarget(int[] arrs, int k)
    {

        int target = arrs.length - k;
        
        int partionIndex = partition(arrs, 0, arrs.length - 1);

        while (partionIndex != target) {
            if( partionIndex < target){
                partionIndex = partition(arrs, partionIndex+1, arrs.length - 1);
            }else{
                partionIndex = partition(arrs, 0, partionIndex - 1);
            }
        }

        return arrs[partionIndex];
    }
    

    public int partition(int arr[] , int start , int end)
    {
        int randIndex = new Random().nextInt(end - start + 1) + start;

        swap(arr, randIndex, end);

        int small = start - 1;
        
        for( int i = start; i < end; i++)
        {
            if( arr[i] < arr[end])
            {
                small++;
                swap(arr, i, small);
            }
        }

        small++;
        swap(arr, small, end);
        return small;
    }

    public void swap(int[] arr , int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2] ;
        arr[index2] = temp;
    }
}

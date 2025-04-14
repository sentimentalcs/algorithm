package sort;

import java.util.Random;

public class QuickSortRecurse {

    public static void main(String[] args)
    {
        int[] arr = {4,1,5,3,6,2,7,8};
        int[] result = (new QuickSortRecurse()).sortArray(arr);
        System.out.println(result);
    }

    public int[] sortArray(int[] nums)
    {
        quickSort(nums,0 , nums.length -1);
        return nums;
    }

    /**
     * 快速排序的基本思想是分治法，排序过程如下：在输入数组中随机选
    取一个元素作为中间值（pivot），然后对数组进行分区（partition），使所有
    比中间值小的数据移到数组的左边，所有比中间值大的数据移到数组的右
    边。接下来对中间值左右两侧的子数组用相同的步骤排序，直到子数组中
    只有一个数字为止
     * @param nums
     * @param start
     * @param end
     */
    public void quickSort(int[] nums, int start, int end)
    {
        if( end > start){
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot+1, end);
        }
    }

    public int partition(int[] nums, int start, int end)
    {
        int random = new Random().nextInt(end -start + 1) + start;

        //将随机数放到最后
        swap(nums, random, end);

        int small = start - 1;
        for( int i = start; i < end; i++){
            if( nums[i] < nums[end]){
                small++;
                swap(nums, i, small);
            }
        }

        small++;
        swap(nums, small, end);
        return small;
    }

    public void swap(int[] nums, int index1, int index2)
    {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
}

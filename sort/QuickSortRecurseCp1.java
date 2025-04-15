package sort;

import java.util.Random;

public class QuickSortRecurseCp1 {

    public static void main(String[] args)
    {
        int[] arr = {4,1,5,3,6,2,7,8};
        int[] result = (new QuickSortRecurseCp1()).sorrtArray(arr);
        System.out.println(result);
    }

    public int[] sorrtArray(int[] arr)
    {
        quickSort(arr,0,arr.length -1);
        return arr;
    }

    public void quickSort(int[] arr, int start ,int end)
    {
        //随机选择一个元素作为，作为中间元素，将所有大于该元素的放在右边，小于该元素的放在左边，然后对子数组同样这么做，直到子数组为1
        if( start < end){
            int middle = partition(arr, start, end);
            quickSort(arr, start, middle - 1);
            quickSort(arr, middle + 1, end);
        }
    }

    public int partition(int[] arr, int start , int end)
    {
        int randomMiddle = new Random().nextInt(end - start + 1) + start;

        //将随机选择的元素和末尾的元素交换
        swap(arr, randomMiddle, end);

        int small = start - 1;

        for(int i = start ; i < end; i++)
        {
            //如果遍历到元素小于最后的元素
            if( arr[i] < arr[end]){

                //将small指针向前移动一格
                small ++;

                //交换位置
                swap(arr, small, i);
            }
        }

        small++;
        swap(arr, small, end);
        
        return small;
    }

    public void swap(int[] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}

package sort;

import java.util.Arrays;

public class mergeSortArr {
    public static void main(String[] args)
    {
        int[] arrs = {4,1,5,6,2,7,8,3};
        int[] reuslt = new mergeSortArr().sortArray(arrs);
        System.out.println(reuslt);
    }

    public int[] sortArray(int[] nums)
    {
        int[] dst = new int[nums.length];
        dst = Arrays.copyOf( nums ,nums.length);
        mergeSort(nums, dst, 0, nums.length);
        return dst;
    }


    

    /**
     * 归并排序也是一种基于分治法的排序算法。为了排序长度为 n 的数组，
    需要先排序两个长度为 n/2 的子数组，然后合并这两个排序的子数组，于是
    整个数组也就排序完毕。


    举个完整过程（src = [1, 3, 5, 2, 4, 6]）：
    初始状态：

    ini
    复制
    编辑
    i=0 (1), j=3 (2), k=0
    步骤：


    i	j	谁小	放到 dst[k]	dst	k 增加到
    1	2	1	dst[0]=1	[1, _, _, _, _, _]	1
    3	2	2	dst[1]=2	[1, 2, _, _, _, _]	2
    3	4	3	dst[2]=3	[1, 2, 3, _, _, _]	3
    5	4	4	dst[3]=4	[1, 2, 3, 4, _, _]	4
    5	6	5	dst[4]=5	[1, 2, 3, 4, 5, _]	5
    x	6	6	dst[5]=6	[1, 2, 3, 4, 5, 6]	6
    最终 dst = [1, 2, 3, 4, 5, 6]，大功告成！


     */
    public void mergeSort(int[] src ,int[] dst, int start , int end)
    {
        if(start + 1 >= end){
            return;
        }

        int mid = (start + end) /2;
        mergeSort(dst, src, start, mid);
        mergeSort(dst, src, mid, end);


        // k代表要被放入的位置
        // i是指针1 ，是左边的数组
        // j是指针2 ，是右边的数组
        int i = start, j = mid, k= start;


        // 两边的数组只要有一方没有处理完就一直处理
        while (i  < mid || j < end) {

            //如果右边处理结束 或者（左边没有处理结束，且左边的当前指针指向的元素 小于 右边当前指针指向的元素，则左边的元素直接赋值到目标数组，且左边的指针+1，目标数组下标+1）
            if(j == end || (i < mid && src[i] < src[j])){
                dst[k++] = src[i++];
            } else{
                //
                dst[k++] = src[j++];
            }
        }
    }

}

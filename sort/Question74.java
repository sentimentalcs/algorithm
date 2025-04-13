package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question74{

    public static void main(String[] args)
    {
        int[][] intervals = {{1,3},{4,5},{8,10},{2,6},{9,12},{15,18}};
        int[][] result = new Question74().merge(intervals);
        System.out.println(result);
    }

    /**
     * 题目：输入一个区间的集合，请将重叠的区间合并。每个区间用两个
    数字比较，分别表示区间的起始位置和结束位置。例如，输入区间[[1, 3], [4, 
    5], [8, 10], [2, 6], [9, 12], [15, 18]]，合并重叠的区间之后得到[[1, 6], [8, 12], 
    [15, 18]]。

    解题思路，先按照每个小数组中的第一个数排序
    得到如下的数组
    [1,3] [2,6]  [4,5]  [8,10]  [9,12]  [15,18]
    
    ✳✳然后遍历这个排好序的数组，判断当前数组的第二个数是否大于下一个数组的第一个数，如果大于，则两个数组之间有重叠，然后判断两个数组中的最后一个数字的大小，取大数字作为数组的第二个数
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals)
    {
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);

        // 这里不要用int[][]，因为不知道具体的大小，可以直接用LinkedList或者ArrayList
        List<int[]> mergedList = new ArrayList<>();
        // int[][] mergedArr = new int[][]{};
        //foreach intervals
        int i = 0;
        while( i < intervals.length){
            int j = i + 1;
            int[] temp = new int[]{intervals[i][0],intervals[i][1]};
            while( j < intervals.length && intervals[j][0] <= temp[1]){
                temp[1] = Math.max(temp[1],intervals[j][1]);
                j++;
            }
            mergedList.add(temp);
            i = j;
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}

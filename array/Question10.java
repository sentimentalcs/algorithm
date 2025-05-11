package array;

import java.util.HashMap;
import java.util.Map;

public class Question10 {

    public static void main(String[] args) {
        int[] arr = {1,-1,2,3,-3};
        int result = new Question10().subarraySum(arr,2);
        System.out.println(result);
    }

    /**
     * 题目：输入一个整数数组和一个整数 k，请问数组中有多少个数字之和
    等于 k 的连续子数组？例如，输入数组[1, 1, 1]，k 的值为 2，有 2 个连续子
    数组之和等于 2
     * @param arr
     * @param k
     * @return
     */
    public int subarraySum(int[] arr, int k)
    {
        //存储前缀和出现的次数
        Map<Integer,Integer> sumToCount = new HashMap<>();

        //保证当前整个子数组正好是等于该值
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int num : arr)
        {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);

            //前缀和Sum出现次数 = 之前的Sum前缀和次数 + 1
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
    
}

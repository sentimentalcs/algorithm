package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Question7 {

    public static void main(String[] args)
    {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>>  result = new Question7().threeSum(arr);
        System.out.println(result);
    }

    /**题目：输入一个数组，如何找出数组中所有和为0的3个数字的
    三元组？需要注意的是，返回值中不得包含重复的三元组。例如，
    在数组[-1，0l'p'l，1，2，-1，-4]中有两个三元组的和为0，它们分别
    是[-1，0，1]和[-1，-1，2]。
    //排序后是 [-4,-1,-1,0,1,2]
     * @param arr
     * @param k
     * @return
     */
    public List<List<Integer>> threeSum(int[] arr)
    {
        //将数组排好序
        Arrays.sort(arr);
        List<List<Integer>> mergedResult = new ArrayList<>();
        if( arr.length < 3){
            return Collections.emptyList();
        } else if(arr.length == 3){
            if(arr[0]+ arr[1] + arr[2] == 0){
                List<List<Integer>> result =  new ArrayList<List<Integer>>();
                List<Integer> innerList = Arrays.stream(arr).boxed().collect(Collectors.toList());
                result.add(innerList);
                return result;
            }
        } else{
            
            int i = 0;
            while(i < arr.length - 2){
                twoSum(arr,mergedResult, i);

                int temp = arr[i];

                //过滤重复元素
                while (temp == arr[i] && i < arr.length) {
                    i++;
                }
            }
            return mergedResult;
        }
        return null;
    }

    public void twoSum(int[] arr,List<List<Integer>> resultList,int k)
    {
        int start = k + 1;
        int end = arr.length - 1;
        while (start < end) {
            int result = arr[start] + arr[end] + arr[k];
            if(result == 0){
                resultList.add(Arrays.asList(arr[start],arr[end],arr[k]));
                //过滤重复元素
                int temp = arr[start];
                while (arr[start] == temp && start < end) {
                    start++;
                }
            }else if(result < 0){
                start++;
                continue;
            }else{
                end--;
            }
        }
    }
    
}

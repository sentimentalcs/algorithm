package array;

import java.util.HashMap;
import java.util.Map;

public class Question11 {

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,1};
        int result = new Question11().findMaxLength(arr);
        System.out.println(result);
    }

    /**
     * 输入一个只包含 0 和 1 的数组，请问如何求 0 和 1 的个数相同
    的最长连续子数组的长度？例如，在数组[0, 1, 0]中有两个子数组包含相同
    个数的 0 和 1，分别是[0, 1]和[1, 0]，它们的长度都是 2，因此输出 2。
     * @param arr
     * @param k
     * @return
     */
    public int findMaxLength(int[] arr)
    {
       Map<Integer,Integer> map = new HashMap<>();
       int maxLength = 0;
       int sum = 0;
       map.put(0,-1);

       for(int i = 0 ; i < arr.length; i++)
       {
          sum += (arr[i] == 0 ? -1 : 1);
          if(map.containsKey(sum)){
            maxLength = Math.max(maxLength, i - map.get(sum));
          }else{
            map.put(sum, i);
          }
          
       }
       return maxLength;
    }
    
}

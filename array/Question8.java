package array;


public class Question8 {

    public static void main(String[] args)
    {
        int[] arr = {5,1,4,3};
        int k = 7;
        int result = new Question8().minSubArrayLen(arr,k);
        System.out.println(result);
    }

    /**输入一个正整数组成的数组和一个正整数k，请问数组中
    和大于或等于k的连续子数组的最短长度是多少？如果不存在所有数
    字之和大于或等于k的子数组，则返回0。例如，输入数组[5，1，
    4，3]，k的值为7，和大于或等于7的最短连续子数组是[4，3]，因
    此输出它的长度2。
     * @param arr
     * @param k
     * @return
     */
    public int minSubArrayLen(int[] arr,int k)
    {
        int left = 0 ;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for( int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            while (left < i && sum >= k) {
                minLen = Math.min(minLen, i - left +1);
                sum -= arr[left++];
            }
        }
        return minLen;
    }
    
}

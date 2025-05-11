package array;

public class Question9 {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 6};
        int result = new Question9().numsSubArrayProductLessThanK(arr,100);
        System.out.println(result);
    }

    /**
     * 题目：输入一个由正整数组成的数组和一个正整数 k，请问数组中有多
    少个数字乘积小于 k 的连续子数组？例如，输入数组[10, 5, 2, 6]，k 的值为
    100，有 8 个子数组的所有数字的乘积小于 100，它们分别是[10]、[5]、[2]、
    [6]、[10, 5]、[5, 2]、[2, 6]和[5, 2, 6]。
     * @param arr
     * @param k
     * @return
     */
    public int numsSubArrayProductLessThanK(int[] arr, int k)
    {
        int left = 0;
        int sum = 1;
        int count = 0;
        for( int i = 0 ; i < arr.length ; i++){
            sum *= arr[i];
            while( sum >= k && left < i)
            {
                sum /= arr[left++];
            }
            count += i >= left ? i - left + 1 : 0;
        }
        return count;
    }
    
}

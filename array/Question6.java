package array;

public class Question6 {

    public static void main(String[] args)
    {
        int[] arr = {1,2,4,6,10,12,13,18};
        int[] result = new Question6().twoSum(arr,16);
        System.out.println(result);
    }

    /**
     * 题目：输入一个递增排序的数组和一个值 k，请问如何在数组中找出两
    个和为 k 的数字并返回它们的下标？假设数组中存在且只存在一对符合条
    件的数字，同时一个数字不能使用两次。例如，输入数组[1, 2, 4, 6, 10]，k
    的值为 8，数组中的数字 2 与 6 的和为 8，它们的下标分别为 1 与 3。
        * @param arr
     * @param k
     * @return
     */
    public int[] twoSum(int[] arr, int k)
    {
        int left = 0;
        int right = arr.length - 1;

        while (left < right && arr[left] + arr[right] != k) {
            if( arr[left] + arr[right] == k ){
                break;
            }

            if( arr[left] + arr[right] < k)
            {
                left++;
            }else{
                right--;
            }
        }

        return new int[]{left,right};
    }
    
}

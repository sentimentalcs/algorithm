package sort;

public class Question75_1 {
    public static void main(String[] args)
    {
        int[] arr = {2,3,4,2,3,2,6,1};
        int[] result = new Question75_1().sortArray(arr);
        System.out.println(result);        
    }
    

    /** 数组中的最大值和最小值差值为k, 数组长度为n,且 k 远小于 n的场景适合用计数排序
     * 计数排序的基本思想是先统计数组中每个整数在数组中出现的次数，
    然后按照从小到大的顺序将每个整数按照它出现的次数填到数组中。例如，
    如果输入整数数组[2, 3, 4, 2, 3, 2, 1]，扫描一次整个数组就能知道数组中 1
    出现了 1 次，2 出现了 3 次，3 出现了 2 次，4 出现了 1 次，于是先后在数
    组中填入 1 个 1、3 个 2、2 个 3 及 1 个 4，就可以得到排序后的数组
    [1, 2, 2,  2, 3, 3, 4]。
     * @param arr
     * @return
     */
    public int[] sortArray(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        int[] count = new int[max - min +1];
    
        for(int i = 0; i < arr.length; i++){
            count[arr[i] - min]++;
        }

        
        int i = 0;
        for(int num = min; num <= max; num++){
            while(count[num - min] > 0){
                //输出多个次数相同的数字
                arr[i++] = num;
                count[num - min]--;

            }
        }
        return count;
    }
}

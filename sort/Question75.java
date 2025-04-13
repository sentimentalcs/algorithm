package sort;

public class Question75 {
    public static void main(String[] args)
    {
        int[] arr1 = {2, 3, 3, 7, 3, 9, 2, 1, 7, 2};
        int[] arr2 = {3, 2, 1};
        int[] result = new Question75().relativeSortArrBooks(arr1,arr2);
        System.out.println(result);        
    }
    

    /** 
     * 
     * 题目：输入两个数组 arr1 和 arr2，其中数组 arr2 中的每个数字都唯一，
    并且都是数组 arr1 中的数字。请将数组 arr1 中的数字按照数组 arr2 中的数
    字的相对顺序排序。如果数组 arr1 中的数字在数组 arr2 中没有出现，那么
    将这些数字按递增的顺序排在后面。假设数组中的所有数字都在 0 到 1000
    的范围内。例如，输入的数组 arr1 和 arr2 分别是[2, 3, 3, 7, 3, 9, 2, 1, 7, 2]和
    [3, 2, 1]，则数组 arr1 排序之后为[3, 3, 3, 2, 2, 2, 1, 7, 7, 9]
     * @param arr
     * @return
     */
    public int[] relativeSortArr(int[] arr1,int[] arr2)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for( int i = 0 ; i < arr1.length; i++){
            min = Math.min(arr1[i],min);
            max = Math.max(arr1[i],max);
        }


        //对每个数组进行计数
        int[] counts = new int[max - min +1];
        for(int i = 0 ; i < arr1.length; i++){
            counts[arr1[i] - min ]++;
        }

        //先按照arr2中的放入arr1中的数组中
        int i = 0;
        for(int j= 0; j < arr2.length; j++){
            while(arr1[arr2[j] - min] > 0){
                arr1[ i++] = arr2[j];
                counts[ arr2[j] - min ] --;
            }
        }

        for(int num = min;  num <= max; num++){
            while(counts[num - min] > 0){
                arr1[i++] = num;
                counts[num - min] --;
            }
        }
        return arr1;
    }

    public int[] relativeSortArrBooks(int[] arr1,int[] arr2)
    {
        //统计每个数字出现的次数
        int[] counts = new int[1000];
        for(int i : arr1)
        {
            counts[i] ++;
        }


        int j = 0;
        for( int i : arr2)
        {
            while(counts[i] > 0){
                arr1[j++] = i;
                counts[i] --;
            }
        }

        for( int i = 0 ; i < counts.length ; i++)
        {
            while(counts[i] > 0){
                arr1[j++] = i;
                counts[i] --;
            }
        }
        return arr1;
    }
}

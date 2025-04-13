package sort;

public class Question74_1 {
    public static void main(String[] args)
    {
        int[] arr = {2,3,4,2,3,2,1};
        int[] result = new Question74_1().sortArray(arr);
        System.out.println(result);        
    }
    

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

package binSearch;

// 题目：输入一个排序的整数数组 nums 和一个目标值 t，如果数组 nums
// 中包含 t，则返回 t 在数组中的下标；如果数组 nums 中不包含 t，则返回将
// t 按顺序插入数组 nums 中的下标。假设数组中没有相同的数字。例如，输
// 入数组 nums 为[1, 3, 6, 8]，如果目标值 t 为 3，则输出 1；如果 t 为 5，则返
// 回 2
public class Question68{
   public static void main(String[] args) {
        int[] nums = {1, 3, 6, 8};
        int target = 3;
        System.out.println(searchInsert(nums, target));
   }

   public static int searchInsert(int[] nums, int target)
   {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int middle = (left + right) / 2;
            if(nums[middle] >= target){
                if(middle == 0 || nums[middle - 1] < target){
                    return middle;
                }
                right = middle - 1;
            }else{
                left = right + 1;
            }
        }
        return nums.length;
   }
}
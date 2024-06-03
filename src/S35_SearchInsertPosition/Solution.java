package S35_SearchInsertPosition;

public class Solution {
    /**
     * 使用bineary search 
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 找到第一個大於等於target的索引就是要插入的結果
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                return mid;
            }

            // 當數組沒有目標值時 下述條件會使left最後 > right 且為第一個大於target的索引
            if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

package S53_MaximumSubarray;

public class Solution {

    /**
     * 使用dp
     */
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0], maxSum = nums[0]; // 紀錄當前組合最大與全局最大

        // 從 index 1 開始遍歷。遍歷每個數字有兩種選擇。拋棄前面數組重新開始或將當前加上前面數組 比較
        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;  
    }
}

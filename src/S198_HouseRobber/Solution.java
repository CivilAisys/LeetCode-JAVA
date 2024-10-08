package S198_HouseRobber;

public class Solution {
	public int rob(int[] nums) {
		// 邊界條件
		if(nums.length == 1){
			return nums[0];
		}

		// dp數組
		int[] dp = new int[nums.length];

		// 初始化dp[0] & dp[1]
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		// 填充dp數組  狀態轉移方程為dp[i] = max(dp[i-1], dp[i-2] + nums[i])
		for(int i = 2; i < nums.length; i++){
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}

		return dp[nums.length - 1];
	}
}

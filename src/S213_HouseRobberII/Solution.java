package S213_HouseRobberII;

public class Solution {
	// 使用dp
	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		// 房子是環繞的 將其拆成兩種情況取最大 1.選頭去尾 2.不選頭包含尾
		int n = nums.length;
		return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
	}

	private int robHelper(int[] nums, int start, int end) {
		if (start == end)
			return nums[start];

		// dp[i] 代表到達索引i的房子最大可以搶的金額 並初始化dp
		int[] dp = new int[nums.length];
		dp[start] = nums[start];
		dp[start + 1] = Math.max(nums[start], nums[start + 1]);

		for (int i = start + 2; i <= end; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[end];
	}
}

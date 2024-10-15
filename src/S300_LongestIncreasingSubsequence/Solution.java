package S300_LongestIncreasingSubsequence;

public class Solution {

	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];  // dp[i] 表示以 nums[i] 結尾的最長遞增子序列的長度
		int maxLen = 1;  // 最長遞增子序列的長度

		// 初始化 dp 陣列，每個位置的值初始為 1
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		// 開始動態規劃計算, 因為遞增子序列不用連續  所以使用雙層迴圈遍歷 i 之前的值來看dp[i] 是否能夠更大
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// 更新最大值
			maxLen = Math.max(maxLen, dp[i]);
		}

		return maxLen;
	}
}

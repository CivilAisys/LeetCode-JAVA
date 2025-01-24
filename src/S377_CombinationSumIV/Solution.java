package S377_CombinationSumIV;

public class Solution {
	public int combinationSum4(int[] nums, int target) {
		// 初始化dp陣列，dp[i] 表示組成 i 的組合數量
		int[] dp = new int[target + 1];
		dp[0] = 1; // 組成0的唯一選擇為空組合

		// 遍歷從 1 到 target 的每一個目標值
		for (int i = 1; i <= target; i++) {
			// 對每個數字進行檢查
			for (int num : nums) {
				if (i >= num) { // 如果當前目標值大於等於數字 num
					dp[i] += dp[i - num];
				}
			}
		}

		return dp[target]; // 返回組成 target 的組合數量
	}
}

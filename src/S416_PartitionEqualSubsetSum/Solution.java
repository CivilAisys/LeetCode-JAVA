package S416_PartitionEqualSubsetSum;

public class Solution {

	// 將問題轉化為0-1 背包問題。通過構建一個 dp 數組來記錄能否找到一個子集
	// 其和等於總和的一半。如果可以，則說明數組可以劃分為兩個和相等的子集
	public boolean canPartition(int[] nums) {
		// 計算數組的總和
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		// 如果是奇數 則不能劃分成兩個相同的子集
		if (sum % 2 != 0) {
			return false;
		}

		int target = sum / 2;
		// dp數組  dp[i]表示可否構成和為i的子集
		boolean[] dp = new boolean[target + 1];
		dp[0] = true; // 和為0無須元素即可達成

		// 遍歷數組的每個數字
		for (int num : nums) {
			// 從 target 開始倒序更新 dp 數組，避免重複使用同一個數字
			for (int i = target; i >= num; i--) {
				dp[i] = dp[i] || dp[i - num]; // dp[i - num] 相當於挑選了num
			}
		}

		return dp[target];
	}
}

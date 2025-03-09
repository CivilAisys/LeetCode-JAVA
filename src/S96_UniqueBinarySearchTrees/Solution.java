package S96_UniqueBinarySearchTrees;

public class Solution {

	// 使用 DP: dp[i] 代表有 i 個節點時，不同的 BST 組合數量
	// 狀態轉移: dp[i] = sum(dp[j-1] * dp[i-j]) ，j 是根節點的位置
	public int numTrees(int n) {
		// 初始化dp
		int[] dp = new int[n + 1];
		dp[0] = 1; // 空樹也是一種有效的結構
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {         // i 代表目前總節點數
			for (int j = 1; j <= i; j++) {     // j 代表將哪個節點作為根節點
				// dp[j-1] 左子樹 dp[i-j] 右子樹
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}

		return dp[n];
	}
}

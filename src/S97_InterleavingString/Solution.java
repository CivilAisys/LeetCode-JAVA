package S97_InterleavingString;

public class Solution {

	// 使用 dp   dp[i][j] 代表 s1 前i個字元 + s2 前j個字元 是否可以組成 s3 前i + j個字元
	public boolean isInterleave(String s1, String s2, String s3) {
		// 長度檢查 interleaving是完美組合
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		// 初始化dp
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true; // 空字串組成空字串

		// 初始化 s1 對應的第一列
		for (int i = 1; i <= s1.length(); i++) {
			dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		}

		// 初始化 s2 對應的第一行
		for (int j = 1; j <= s2.length(); j++) {
			dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
		}

		// 狀態轉移方程
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				char c3 = s3.charAt(i + j - 1);

				// 來自 s1
				boolean fromS1 = dp[i - 1][j] && c1 == c3;
				// 來自 s2
				boolean fromS2 = dp[i][j - 1] && c2 == c3;

				dp[i][j] = fromS1 || fromS2;
			}
		}

		return dp[s1.length()][s2.length()];
	}
}

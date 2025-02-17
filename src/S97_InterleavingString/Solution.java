package S97_InterleavingString;

public class Solution {

	// 使用 dp   dp[i][j] 代表 s1 前i個字元 + s2 前j個字元 是否可以組成 s3 前i + j個字元
	public boolean isInterleave(String s1, String s2, String s3) {
		// 長度檢查
		if (s1.length() + s2.length() < s3.length()) {
			return false;
		}
		// 初始化dp
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true; // 空字串組成空字串



	}
}

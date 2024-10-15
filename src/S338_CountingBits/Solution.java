package S338_CountingBits;

public class Solution {

	public int[] countBits(int n) {
		// 建立長度為 n + 1的 dp數組
		int[] dp = new int[n + 1];

		// 填充dp數組
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i >> 1] + (i & 1); // dp[i >> 1]等於除2 且前面就有推導過  所以要在確認被丟棄的最低位是否為1 所以使用 i & 1
		}

		return dp;
	}
}

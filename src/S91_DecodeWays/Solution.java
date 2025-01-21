package S91_DecodeWays;

public class Solution {

	public int numDecodings(String s) {
		// 0 開頭為非法字串
		if (s.charAt(0) == '0')
			return 0;

		int length = s.length();
		int[] dp = new int[length]; // dp[i] 表示 s 在索引 i 時的解碼"數量" 僅在合法組合下
		dp[0] = 1; // 初始化

		// 遍歷字串
		for (int i = 1; i < length; i++) {
			char current = s.charAt(i); // 當前字符
			char last = s.charAt(i - 1); // 前一個字符

			// 狀態轉移方程
			// 當前字符為 '0' 的特殊處理
			if (current == '0') {
				// 只能與前一個字符組合成 '10' 或 '20'
				if (last == '1' || last == '2') {
					dp[i] = (i == 1) ? 1 : dp[i - 2]; // 組合解碼並考慮越界情況
				} else {
					return 0; // 後續也不會有合法情況 故直接返回0
				}
			} else {
				// 單獨解碼當前字符
				dp[i] = dp[i - 1]; // 延續解碼數量

				// 與前一個字符組合解碼  組合 10 - 26間
				if(last == '1'|| (last == '2' && current <= '6')){
					dp[i] += (i == 1) ? 1 : dp[i - 2];
				}
			}
		}
		return dp[length - 1];
	}
}

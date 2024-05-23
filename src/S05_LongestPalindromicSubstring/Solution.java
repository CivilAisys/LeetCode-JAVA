package S05_LongestPalindromicSubstring;

public class Solution {

	/**
	 * 使用two pointer 迴文特性為1.中間向兩側擴展並具有對稱性
	 * 中間向兩側擴展要考慮從2字符或1字符進行擴展
	 */
	public String longestPalindrome(String s) {
		if (s.length() == 1)
			return s;

		int start = 0, end = 0; // 起始index
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i); //奇數回文 以s[i]為中心
			int len2 = expandAroundCenter(s, i, i + 1); //偶數回文 以s[i] 和 s[i+1] 為中心
			int len = Math.max(len1, len2); //取得當前最大回文長度

			// 當len長度大於 end - start時。更新左右邊界
			if (len > end - start) {
				// 計算左右邊界 start 需要len - 1 是因為在偶數回文情況下 len / 2 會失效
				start = i - (len - 1) / 2;
				end = i + len / 2; // 
			}
		}
		return s.substring(start, end + 1);
	}

	/**
	 * 判斷給定起始點的最大回文長度
	 */
	private int expandAroundCenter(String s, int left, int right) {
		// 條件為不超出左右邊界且雙指針的值相等
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1; // 回文長度
	}
}

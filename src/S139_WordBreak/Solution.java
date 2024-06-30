package S139_WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	/**
	 * 使用dp
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		// 使用set來快速查找
		Set<String> wordSet = new HashSet<>(wordDict);
		// dp 數組 表示s的前i個字符能否被拆分  長度為s.length + 1是因為要包含空字串的部分
		boolean[] dp = new boolean[s.length() + 1];
		// 初始狀態  空自串一定可以被拆分
		dp[0] = true;
		// i從1 是因為對應到dp數組 0已經為true 
		// 且使用subString不包含i 但是因為dp多字串索引1 所以剛好會對應
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		// 返回dp數組的最後一個值  代表整個字符串能否被拆分
		return dp[s.length()];
	}
}

package S424_LongestRepeatingCharacterReplacement;

public class Solution {

	// 使用滑動窗口
	public int characterReplacement(String s, int k) {
		// 用來記錄每個字符出現的次數
		int[] charCount = new int[26];
		int left = 0;
		int maxCount = 0; // 窗口內出現最多次數的字符
		int maxLength = 0; // 最長的子字串長度

		// 遍歷字串
		for (int right = 0; right < s.length(); right++) {
			// 當前字串計數 +1
			charCount[s.charAt(right) - 'A']++;
			// 更新最大計數
			maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

			// 檢查當前窗口是否符合條件
			// 若窗口長度 - 最大重複字符的計數 > k 則需要縮小窗口
			if (right - left + 1 - maxCount > k) {
				// 移除左邊界 縮小窗口
				charCount[s.charAt(left) - 'A']--;
				left++;
			}
			// 更新最大字串長度
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}
}

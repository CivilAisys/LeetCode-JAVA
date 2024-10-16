package S409_LongestPalindrome;

import java.util.HashMap;

public class Solution {

	public int longestPalindrome(String s) {
		// 用來存放每個字符出現的次數
		HashMap<Character, Integer> countMap = new HashMap<>();

		// 計算字符出現次數
		for (char c : s.toCharArray()) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}

		int palindromeLength = 0;
		boolean hasOdd = false;  // 是否有奇數次數的字符

		// 遍歷字符次數
		for (int count : countMap.values()) {
			if (count % 2 == 0) {
				// 字符偶數次  可以用來構建迴文
				palindromeLength += count;
			} else {
				// 奇數次  可以使用奇偶數部分
				palindromeLength += count - 1;
				hasOdd = true;
			}
		}

		// 有奇數  可以使用其當作中心點  故長度+1
		if (hasOdd) {
			palindromeLength += 1;
		}

		return palindromeLength;
	}
}

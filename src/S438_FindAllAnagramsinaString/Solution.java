package S438_FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	// 使用滑動窗口計算
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();

		if (s.length() < p.length()) {
			return result;
		}

		// 字母表紀錄 s(窗口範圍) 和 p的字母出現頻率
		int[] pCount = new int[26];
		int[] sCount = new int[26];

		// 計算字串p 每個字母出現的頻率
		for (int i = 0; i < p.length(); i++) {
			pCount[p.charAt(i) - 'a']++;
		}

		// 開始滑動窗口處理
		for (int i = 0; i < s.length(); i++) {
			// 加入新字符到當前窗口
			sCount[s.charAt(i) - 'a']++;

			// 保持滑動窗口大小為p的長度  移除最左邊元素
			if (i >= p.length()) {
				sCount[s.charAt(i - p.length()) - 'a']--;
			}

			// 檢查窗口是否為異位詞
			if (isAnagram(pCount, sCount)) {
				result.add(i - p.length() + 1);
			}
		}

		return result;
	}

	// 比較兩個計數器是否相同
	private boolean isAnagram(int[] pCount, int[] sCount) {
		for (int i = 0; i < 26; i++) {
			if (pCount[i] != sCount[i]) {
				return false;
			}
		}
		return true;
	}
}

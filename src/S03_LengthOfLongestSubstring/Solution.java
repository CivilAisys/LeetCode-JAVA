package S03_LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		// 傳入空字串直接回覆0
		if (s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>(); //儲存每個字元出現的最新索引
		int left = 0; // 不重複字串的開頭索引
		int maxLength = 1; //長度至少為1

		for (int index = 0; index < s.length(); index++) {
			// 若當前字元最後出現索引 大於等於不重複開頭  更新開頭索引
			char currentChar = s.charAt(index);
			if (map.containsKey(currentChar)) {
				if (map.get(currentChar) >= left) {
					left = map.get(currentChar) + 1; // 移動到重覆字元的下一個重新計算
				}
			}

			map.put(currentChar, index); // 更新當前字元最新索引
			maxLength = Math.max(maxLength, index - left + 1); // 更新最大長度
		}

		return maxLength;
	}
}

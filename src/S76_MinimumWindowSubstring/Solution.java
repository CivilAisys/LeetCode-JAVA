package S76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";

		// 計算t字串各字元出現次數
		Map<Character, Integer> tMap = new HashMap<>();
		for (Character c : t.toCharArray()) {
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
		}

		// 左右邊界
		int left = 0, right = 0;
		// 窗口字元頻率
		Map<Character, Integer> windowMap = new HashMap<>();
		// 最小窗口長度及初始位置
		int minLength = Integer.MAX_VALUE;
		int start = 0;

		// 符合條件的字元數量
		int matchCount = 0;

		while (right < s.length()) {
			// 將右指針指向字元加入窗口
			char c = s.charAt(right);
			windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

			// 若該字元在 t 中且次數符合 matchCount增加
			if (tMap.containsKey(c) && tMap.get(c).equals(windowMap.get(c))) {
				matchCount++;
			}

			// 當窗口內的字元完全覆蓋 t 時，開始縮小窗口
			while (matchCount == tMap.size()) {
				// 更新最小窗口長度
				if (right - left + 1 < minLength) {
					minLength = right - left + 1;
					start = left;
				}

				// 左指針移動並移除字元
				char removeChar = s.charAt(left);
				windowMap.put(removeChar, windowMap.get(removeChar) - 1);
				if (tMap.containsKey(removeChar) && windowMap.get(removeChar) < tMap.get(removeChar)) {
					matchCount--;
				}

				left++; // 縮小窗口
			}
			right++; //擴大窗口
		}

		// 如果 minLength 未被更新，表示找不到符合條件的子串
		return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
	}
}

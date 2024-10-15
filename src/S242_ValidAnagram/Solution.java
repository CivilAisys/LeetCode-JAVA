package S242_ValidAnagram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public boolean isAnagram(String s, String t) {
		// 長度不同的話一定不是變位詞
		if (s.length() != t.length()) {
			return false;
		}

		// 紀錄字母出現的頻率
		int[] count = new int[26];

		// 遍歷s & t
		for (int i = 0; i < s.length(); i++) {
			// s字母頻率增加 t 字母頻率減少
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}

		// 檢查count裡面是否都為0
		for (int c : count) {
			if (c != 0) {
				return false;
			}
		}

		return true;
	}


	public boolean isAnagram1(String s, String t) {
		// 如果兩個字串長度不同，則不可能是變位詞
		if (s.length() != t.length()) {
			return false;
		}

		// 將字串轉換為字元陣列並排序
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Arrays.sort(sArray);
		Arrays.sort(tArray);

		// 使用 Set 來存放排序後的字串
		Set<String> set = new HashSet<>();
		set.add(new String(sArray));
		set.add(new String(tArray));

		// 如果 Set 內的元素數量為 1，則表示兩個排序後的字串相同，是變位詞
		return set.size() == 1;
	}
}

package S14_LongestCommonPrefix;

public class Solution {

	/**
	 * 使用地一個字進行前綴比對  沒有比對到就直接將prefix -1
	 */
	public String longestCommonPrefix(String[] strs) {
		String prefix = strs[0]; // 使用第一個字來比對

		for (String str : strs) {
			// 判斷是否開頭為prefix  沒有就將prefix長度 - 1
			while (!str.startsWith(prefix)) {
				prefix = prefix.substring(0, prefix.length() - 1); // 將字串截斷少一個字元
			}
		}
		return prefix;
	}
}
package S383_RansomNote;

public class Solution {

	public boolean canConstruct(String ransomNote, String magazine) {
		// 創建長度為26的數組來計算每個字符在magazine出現的次數
		int[] count = new int[26];

		// 遍歷magazine 紀錄字符出現的次數
		for (char c : magazine.toCharArray()) {
			count[c - 'a']++;
		}

		// 遍歷ransomNote 檢查每個字符是否能在magazine中找到足夠次數的匹配
		for (char c : ransomNote.toCharArray()) {
			if (count[c - 'a'] == 0) {
				return false;
			}
			count[c - 'a']--; // 減少字符可用次數
		}

		return true;
	}
}

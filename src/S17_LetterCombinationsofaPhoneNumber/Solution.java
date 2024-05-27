package S17_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用backtracking來列出所有可能
 */
public class Solution {

	// 數字到字母的映射
	private static final String[] KEYPAD = { "",    // 0
			"",    // 1
			"abc", // 2
			"def", // 3
			"ghi", // 4
			"jkl", // 5
			"mno", // 6
			"pqrs",// 7
			"tuv", // 8
			"wxyz" // 9
	};

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length() == 0) {
			return result;
		}
		backTracking(result, digits, new StringBuilder(), 0);
		return result;
	}

	private void backTracking(List<String> result, String digits, StringBuilder current, int currentIndex) {
		// 中止條件為 currentIndex等於digits長度即將結果加入
		if (digits.length() == currentIndex) {
			result.add(current.toString());
			return;
		}

		String letters = KEYPAD[digits.charAt(currentIndex) - '0']; //取得當前要加入的字串
		for (char letter : letters.toCharArray()) {
			current.append(letter); //將當前字元加入
			backTracking(result, digits, current, currentIndex + 1); //進行遞迴列舉
			current.deleteCharAt(current.length() - 1); //將前面加入的字元刪除已達成回溯
		}
	}
}
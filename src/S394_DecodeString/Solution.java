package S394_DecodeString;

import java.util.Stack;

public class Solution {

	public String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>(); // 用來存放重複次數的棧
		Stack<StringBuilder> stringStack = new Stack<>(); // 用來存放字串的棧
		StringBuilder currentString = new StringBuilder(); // 當前處理字串
		int k = 0; // 存放當前獨到的數字

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				// 當前字符是數字  累積讀取數字
				k = k * 10 + (c - '0');
			} else if (c == '[') {
				// 遇到左括號 將當前數字和當前字串壓入棧
				countStack.push(k);
				stringStack.push(currentString);
				// 使用新的子字串處理  重置當前字串和k
				currentString = new StringBuilder();
				k = 0;
			} else if (c == ']') {
				// 遇到右括號 將子字串重複 k 次 並加到上一層的字串
				int repeatTimes = countStack.pop();
				StringBuilder decodedString = stringStack.pop();
				// 重複字串並串接上一層
				for (int i = 0; i < repeatTimes; i++) {
					decodedString.append(currentString);
				}

				// 串接好的字串當作當前字串  繼續處理
				currentString = decodedString;
			} else {
				// 字母直接加入當前字串
				currentString.append(c);
			}
		}

		return currentString.toString();
	}
}

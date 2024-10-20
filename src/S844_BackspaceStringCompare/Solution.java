package S844_BackspaceStringCompare;

import java.util.Stack;

public class Solution {

	public boolean backspaceCompare(String s, String t) {
		return buildString(s).equals(buildString(t));
	}

	private String buildString(String s) {
		// 使用Stack來輔助並模擬退格
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '#') {
				if (!stack.isEmpty()) {
					stack.pop(); // 模擬退格
				}
			} else {
				stack.push(c);
			}
		}
		// 使用StringBuilder 將 Stack內容轉換為字串
		StringBuilder result = new StringBuilder();
		for (char c : stack) {
			result.append(c);
		}
		return result.toString();
	}
}

package S20_ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	/**
	 * 使用stack來判斷是否為合法的括號
	 */
	public boolean isValid(String s) {
		// map儲存閉合括號對應的括號
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack = new Stack<>(); // 用於存放開放括號

		// 遍歷字串 遇到開放括號就放進stack中 遇到閉合就將stack pop出比對是否一致
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) { // 閉合括號
				// 如果stack是空的(要檢查不然會有EmptyStackException) 或是 stack pop出來的括號不符合map中的對應值
				if (stack.isEmpty() || stack.pop() != map.get(c)) {
					return false;
				}
			} else { // 開放括號
				stack.push(c);
			}
		}
		// 若是stack為空  代表所有開放括號都有合法匹配到
		return stack.isEmpty();
	}
}

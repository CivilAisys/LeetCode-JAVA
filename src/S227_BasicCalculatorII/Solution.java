package S227_BasicCalculatorII;

import java.util.Stack;

public class Solution {

	/**
	 * 時間複雜度 : O(N)
	 * 空間複雜度 : O(N)
	 */
	public int calculate(String s) {
		// 移除空格
		s = s.replaceAll(" ", "");

		// 使用stack輔助處理優先級問題
		Stack<Integer> stack = new Stack<>();
		char lastOperator = '+';
		int currentNumber = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// 如果是數字  累加到currentNumber
			if (Character.isDigit(c)) {
				currentNumber = currentNumber * 10 + (c - '0');
			}
			// 非數字 或是最後一個數字
			if (!Character.isDigit(c) || i == s.length() - 1) {
				// 遇到非數字或最後一個數字時需要依照上一輪的operator 進行計算後放入stack
				switch (lastOperator) {
					case '+' -> stack.push(currentNumber);
					case '-' -> stack.push(-currentNumber);
					case '*' -> stack.push(stack.pop() * currentNumber);
					case '/' -> stack.push(stack.pop() / currentNumber);
				}

				// 更新currentNumber 及 lastOperator
				currentNumber = 0;
				lastOperator = c;
			}
		}

		// 將stack內所有加總
		int result = 0;
		for (Integer num : stack) {
			result += num;
		}

		return result;
	}
}

package S150_EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {

	public int evalRPN(String[] tokens) {
		// 使用stack來除存操作數
		Stack<Integer> stack = new Stack<>();

		for (String token : tokens) {
			if (isOperator(token)) {
				// 如果是操作符  從棧中彈出個操作數並做運算
				int b = stack.pop();
				int a = stack.pop();

				int result = applyOperation(token, a, b);
				// 將結果壓入棧中
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		// 剩餘元素即為結果
		return stack.pop();
	}

	private boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}

	private int applyOperation(String operator, int a, int b) {
		switch (operator) {
			case "+" -> {
				return a + b;
			}
			case "-" -> {
				return a - b;
			}
			case "*" -> {
				return a * b;
			}
			case "/" -> {
				return a / b;
			}
			default -> {
				throw new IllegalArgumentException();
			}
		}
	}
}

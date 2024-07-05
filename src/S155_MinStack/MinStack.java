package S155_MinStack;

import java.util.Stack;

public class MinStack {

	// 使用兩個stack來輔助
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);
		// 當minStack為空 或是 val 小於棧頂元素時壓入
		if (minStack.isEmpty() || val <= minStack.peek()) {
			minStack.push(val);
		}
	}

	public void pop() {
		// 若要彈出的元素與minStack頂部元素相同  也需要從minStack中彈出
		if (stack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}

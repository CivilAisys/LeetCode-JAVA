package S232_ImplementQueueusingStacks;

import java.util.Stack;

public class MyQueue {

	private Stack<Integer> inStack;
	private Stack<Integer> outStack;

	public MyQueue() {
		inStack = new Stack<>();
		outStack = new Stack<>();
	}

	public void push(int x) {
		inStack.push(x); // 入隊時 直接壓入inStack
	}

	public int pop() {
		// 若outStack為空 則將inStack元素移入outStack中
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		} return outStack.pop();
	}

	public int peek() {
		// 與 pop 相同
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.peek();
	}

	public boolean empty() {
		// 當inStack和outStack皆為空時隊列才是空的
		return inStack.isEmpty() && outStack.isEmpty();
	}
}

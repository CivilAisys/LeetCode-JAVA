package S173_BinarySearchTreeIterator;

import java.util.Stack;

public class BSTIterator {

	// 使用stack輔助
	Stack<TreeNode> stack;

	// 中序遍歷的順序為 左 -> 中 -> 右
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		pushLeft(root); // 先把左子樹壓入stack
	}

	private void pushLeft(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public int next() {
		TreeNode node = stack.pop();
		if (node.right != null) {
			pushLeft(node.right);
		}
		return node.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

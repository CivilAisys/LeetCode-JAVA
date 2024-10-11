package S230_KthSmallestElementinaBST;

public class Solution {

	private int count = 0; // 計算訪問的節點數
	private int result = 0; // 保存第 k 小的節點值

	/**
	 * 使用中序遍歷  因為該順序為升序(左 -> 根 -> 右)
	 */
	public int kthSmallest(TreeNode root, int k) {
		inOrderTraversal(root, k);
		return result;
	}

	private void inOrderTraversal(TreeNode node, int k) {
		// 中止條件
		if (node == null) {
			return;
		}

		// 遞歸左子樹
		inOrderTraversal(node.left, k);

		// 訪問當前節點
		count++; // 訪問一個就計數器 +1
		if (count == k) {
			result = node.val;
			return;
		}

		// 遞歸右子樹
		inOrderTraversal(node.right, k);
	}
}

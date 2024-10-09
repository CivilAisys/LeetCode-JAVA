package S226_InvertBinaryTree;

public class Solution {

	public TreeNode invertTree(TreeNode root) {
		// 終止條件  節點為空返回null
		if (root == null) {
			return null;
		}

		// 遞迴反轉左右子樹
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		// 交換左右子樹
		root.left = right;
		root.right = left;

		return root;
	}
}

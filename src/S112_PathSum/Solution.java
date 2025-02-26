package S112_PathSum;

public class Solution {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		return dfs(root, targetSum);
	}

	private boolean dfs(TreeNode node, int remainSum) {
		// 終止條件
		if (node == null) {
			return false;
		}
		// 更新剩餘目標值
		remainSum -= node.val;
		// 到達葉節點時是否滿足條件
		if (node.left == null & node.right == null) {
			return remainSum == 0;
		}

		// 左右子樹遞迴
		return dfs(node.left, remainSum) || dfs(node.right, remainSum);
	}
}

package S129_SumRoottoLeafNumbers;

public class Solution {

	public int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	private int dfs(TreeNode node, int pathSum) {
		if (node == null) {
			return 0;
		}
		// 將當前節點數字串接
		pathSum = pathSum * 10 + node.val;
		// 抵達葉節點
		if (node.left == null && node.right == null) {
			return pathSum;
		}
		// 遞迴左右子樹加總
		return dfs(node.left, pathSum) + dfs(node.right, pathSum);
	}
}

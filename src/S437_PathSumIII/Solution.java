package S437_PathSumIII;

public class Solution {

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return 0;

		// 計算以當前節點作為開頭的路徑數
		int pathFromRoot = findPaths(root, targetSum);

		// 計算以左右節點為開頭的路徑數
		int pathFromLeft = pathSum(root.left, targetSum);
		int pathFromRight = pathSum(root.right, targetSum);

		return pathFromRoot + pathFromLeft + pathFromRight;
	}

	private int findPaths(TreeNode node, long targetSum) {
		if (node == null)
			return 0;

		int paths = 0;

		// 當前節點等於targetSum 找到路徑
		if (node.val == targetSum) {
			paths++;
		}

		// 左右子樹遞歸
		paths += findPaths(node.left, targetSum - node.val);
		paths += findPaths(node.right, targetSum - node.val);

		return paths;
	}
}

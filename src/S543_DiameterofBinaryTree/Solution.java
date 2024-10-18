package S543_DiameterofBinaryTree;

public class Solution {

	private int maxDiameter = 0; // 用來追蹤最大直徑

	// 樹的直徑是二元樹中兩個節點間的最長路徑長度。這條路徑可能通過某個節點的左子樹和右子樹。
	// 對於每個節點，最長的路徑是該節點的左子樹最大深度加上右子樹最大深度
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return maxDiameter;
	}

	// 計算每個節點的深度，並在過程中更新最大直徑
	private int depth(TreeNode node) {
		if (node == null) {
			return 0; // 空節點深度為0
		}

		// 計算左右子樹深度
		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);

		// 更新最大直徑
		maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
		// 返回深度 +1是因為包含當前節點
		return Math.max(leftDepth, rightDepth) + 1;
	}
}

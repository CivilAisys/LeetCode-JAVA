package S199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

	// 使用 DFS
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<>();
		dfs(root, 0, rightView);
		return rightView;
	}

	private void dfs(TreeNode node, int depth, List<Integer> rightView) {
		if (node == null) {
			return;
		}

		// 當前深度等於結果列表大小 代表是該層第一次訪問的節點
		if (depth == rightView.size()) {
			rightView.add(node.val);
		}

		// 先遍歷右子樹在遍歷左子樹
		dfs(node.right, depth + 1, rightView);
		dfs(node.left, depth + 1, rightView);
	}
}

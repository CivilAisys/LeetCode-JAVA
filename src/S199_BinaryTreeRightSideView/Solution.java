package S199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	// 使用 BFS
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<>();
		if (root == null) {
			return rightView;
		}

		// 使用隊列輔助
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		// BFS 層序遍歷
		while (!queue.isEmpty()) {
			int levelSize = queue.size(); // 當層的節點數量

			for (int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();

				// 當層最後一個節點  加入結果
				if (i == levelSize - 1) {
					rightView.add(currentNode.val);
				}

				// 先將左子節點加入  再加入右子節點
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}

		}
		return rightView;
	}
}

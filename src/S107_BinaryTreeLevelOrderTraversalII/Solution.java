package S107_BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>(); // 使用鏈表輔助插入
		if (root == null)
			return result;

		// 使用queue來輔助遍歷 並將root插入
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size(); // 當層節點數
			List<Integer> currentLevel = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();
				currentLevel.add(current.val);

				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
			result.addFirst(currentLevel); // 插入頭部來達成反目的
		}
		return result;
	}
}

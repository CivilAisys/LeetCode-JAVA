package S103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>(); // 使用queue輔助層序遍歷
		queue.offer(root);
		boolean isLeftToRight = true; // 來判斷該從左還右進行遍歷

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentLevel = new LinkedList<>(); // 使用鏈表幫助紀錄當層順序

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				// 根據方向加入結果
				if (isLeftToRight) {
					currentLevel.add(node.val);
				} else {
					currentLevel.add(0, node.val); // 右到左 插入頭部
				}

				// 加入左右子節點
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			isLeftToRight = !isLeftToRight; // 改變方向
			result.add(currentLevel); // 加入結果
		}
		return result;
	}
}

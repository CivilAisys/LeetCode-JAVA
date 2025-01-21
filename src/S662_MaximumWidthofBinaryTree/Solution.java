package S662_MaximumWidthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static class Pair {

		TreeNode node;
		int index;

		Pair(TreeNode node, int index) {
			this.node = node;
			this.index = index;
		}
	}

	/**
	 * 二元樹  當前節點的下兩個節點計算為 index   left = 2 * index   right = 2 * index + 1
	 */
	public int widthOfBinaryTree(TreeNode root) {
		int maxWidth = 0;
		Queue<Pair> queue = new LinkedList<>(); // 使用自訂結構Pair輔助紀錄index
		queue.offer(new Pair(root, 0)); // 根節點索引為0

		while (!queue.isEmpty()) {
			int size = queue.size(); // 當層節點數
			int start = queue.peek().index; // 最左節點
			int end = queue.peek().index; // 最右節點 初始化為最左
			// 遍歷當層節點並更新最右節點
			for (int i = 0; i < size; i++) {
				Pair current = queue.poll();
				TreeNode node = current.node;
				int index = current.index;

				// 更新最右節點
				end = index;
				// 左子節點
				if (node.left != null) {
					queue.offer(new Pair(node.left, index * 2));
				}

				if (node.right != null) {
					queue.offer(new Pair(node.right, index * 2 + 1));
				}
			}
			// 計算最大寬度
			maxWidth = Math.max(maxWidth, end - start + 1);
		}

		return maxWidth;
	}
}


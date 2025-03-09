package S95_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	// 使用 backTracking(窮舉)
	public List<TreeNode> generateTrees(int n) {
		return buildTree(1, n);
	}

	private List<TreeNode> buildTree(int start, int end) {
		List<TreeNode> allTrees = new ArrayList<>();

		// 超過範圍直接返回並加入null
		if (start > end) {
			allTrees.add(null);
			return allTrees;
		}

		// 遍歷每個節點當作根節點的情況
		for (int i = start; i <= end; i++) {
			// 建立左子樹可能的組合 範圍start -> i - 1
			List<TreeNode> leftTrees = buildTree(start, i - 1);

			// 右子樹可能組合  範圍 i + 1 -> end
			List<TreeNode> rightTrees = buildTree(i + 1, end);

			//遍歷左右子樹並組合成可能結果來建立當前所有可能結果
			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					// 依照i當作根節點
					TreeNode current = new TreeNode(i);
					current.left = left;
					current.right = right;
					allTrees.add(current);
				}
			}
		}
		return allTrees;
	}

}

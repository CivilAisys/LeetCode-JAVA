package S222_CountCompleteTreeNodes;

public class Solution {

	// 完全二元樹代表除了最後一層以外其他都是滿的 並且在這個條件下可以再遞回中判斷是否為滿二元樹(左右子樹高度相同) 即可使用公式計算節點數量
	public int countNodes(TreeNode root) {
		// 中止條件
		if (root == null)
			return 0;
		// 計算左右子樹高度
		int leftHeight = getLeftHeight(root);
		int rightHeight = getRightHeight(root);

		// 判斷是否滿二元樹 是的話可以直接使用公式計算
		if (leftHeight == rightHeight) {
			return (1 << leftHeight) - 1;
		} else {
			// 遞回計算左右子樹
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	private int getRightHeight(TreeNode node) {
		int height = 0;
		while (node != null) {
			height++;
			node = node.right;
		}
		return height;
	}

	private int getLeftHeight(TreeNode node) {
		int height = 0;
		while (node != null) {
			height++;
			node = node.left;
		}
		return height;
	}
}

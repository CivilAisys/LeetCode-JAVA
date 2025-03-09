package S114_FlattenBinaryTreetoLinkedList;

public class Solution {

	// 遞迴  前序遍歷的順序是 根 -> 左 -> 右
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		// 遞迴處理左右子樹
		flatten(root.left);
		flatten(root.right);

		// 遇到左子樹不為空時
		if (root.left != null) {
			// 找到左子樹展開後的最右節點
			TreeNode rightmost = root.left;
			while (rightmost.right != null) {
				rightmost = rightmost.right;
			}

			// 將左子樹的最右節點接到原本的右子樹上
			rightmost.right = root.right;
			// 將左子樹接到右子樹上
			root.right = root.left;
			root.left = null;
		}
	}
}

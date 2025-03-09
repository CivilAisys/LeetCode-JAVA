package S99_RecoverBinarySearchTree;

public class Solution {
	TreeNode prev = new TreeNode(Integer.MIN_VALUE); // 前一個節點  用來比對查找錯序節點
	TreeNode first; // 第一個錯序節點
	TreeNode second; // 第二個錯序節點

	// 中序遍歷 左 -> 根 -> 右 會得到遞增序列
	public void recoverTree(TreeNode root) {
		// 1.中序遍歷 找到錯序節點
		inorderTraversal(root);

		// 2.交換錯序節點的值
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private void inorderTraversal(TreeNode root) {
		if(root == null){
			return;
		}
		// 遞迴遍歷左子樹
		inorderTraversal(root.left);

		// 發現錯序對
		if (prev.val > root.val) {
			if (first == null) {
				first = prev;  // 記錄第一個錯序節點 (較大)
			}
			second = root;     // 持續更新第二個錯序節點 (較小)
		}
		prev = root; // 更新前一個節點指標

		// 遞迴遍歷右子樹
		inorderTraversal(root.right);
	}
}

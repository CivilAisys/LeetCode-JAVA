package S572_SubtreeofAnotherTree;

public class Solution {

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		// 若主數為空樹 則subRoot不可能為其子樹
		if (root == null) {
			return false;
		}
		// 判斷當前節點的子樹是否與subRoot相同
		if (isSameTree(root, subRoot)) {
			return true;
		}

		// 遞歸檢查左右子樹
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	// 判斷兩棵樹是否完全相同
	private boolean isSameTree(TreeNode s, TreeNode t) {
		// 如果兩棵樹都為空，則它們是相同的
		if (s == null && t == null) {
			return true;
		}
		// 如果其中一棵樹為空，另一棵不為空，則它們不同
		if (s == null || t == null) {
			return false;
		}
		// 如果當前節點的值不同，則它們不同
		if (s.val != t.val) {
			return false;
		}
		// 遞歸比較左子樹和右子樹
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}

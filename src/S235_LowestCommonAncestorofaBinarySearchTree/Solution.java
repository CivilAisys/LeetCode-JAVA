package S235_LowestCommonAncestorofaBinarySearchTree;

public class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 循環遍歷樹
		while (root != null) {
			// 如果p和q都比當前節點小 則LCA在左子樹
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else if (p.val > root.val && q.val > root.val) {
				// p和q都大於當前節點 LCA在右子樹
				root = root.right;
			} else {
				// 當前節點為LCA
				return root;
			}
		}
		return null;
	}
}

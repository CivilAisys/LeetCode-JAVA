package S236_LowestCommonAncestorofaBinaryTree;

public class Solution {

	/*
	 * 與235不同是此題為一般的BinaryTree而非BST
	 * 最低共同祖先是最接近 p 和 q 且同時包含它們的節點
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 中止條件 若當前節點為null 或等於p或q 則直接返回當前節點
		if (root == null || root == p || root == q) {
			return root;
		}

		// 遞歸遍歷左子樹
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		// 遞歸遍歷右子樹
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// 若p和q分別位於當前節點左右兩邊 代表當前節點為LCA
		if (left != null && right != null) {
			return root;
		}

		//若不再兩側 返回非空的一側
		return left != null ? left : right;
	}
}

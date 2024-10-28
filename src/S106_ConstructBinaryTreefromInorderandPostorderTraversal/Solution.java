package S106_ConstructBinaryTreefromInorderandPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	private Map<Integer, Integer> inorderIndexMap;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		inorderIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}
		return buildTreeHelper(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
	}


	private TreeNode buildTreeHelper(int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}

		// 後序遍歷中 根節點為最後一個元素
		int rootVal = postorder[postEnd];
		TreeNode root = new TreeNode(rootVal);

		// 找到根節點在中序遍歷中的索引
		int rootIndex = inorderIndexMap.get(rootVal);

		// 計算左子樹大小
		int leftSize = rootIndex - inStart;

		// 遞迴構建左右子樹
		root.left = buildTreeHelper(postorder, postStart, postStart + leftSize - 1, inStart, rootIndex - 1);
		root.right = buildTreeHelper(postorder, postStart + leftSize, postEnd - 1, rootIndex + 1, inEnd);

		return root;
	}
}

package S109_ConvertSortedListtoBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// 使用 中序遞迴 來確保樹高度平衡 此題保證鏈表排序好的騎況下才能使用中序遞迴
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		// 先將鏈表轉換成List
		List<Integer> nums = new ArrayList<>();
		while (head != null) {
			nums.add(head.val);
			head = head.next;
		}

		return buildTree(nums, 0, nums.size() - 1);
	}

	private TreeNode buildTree(List<Integer> nums, int left, int right) {
		if (left > right)
			return null; // 終止條件
		// 選擇中間節點
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums.get(mid));
		// 遞迴構建左右子樹
		root.left = buildTree(nums, left, mid - 1);
		root.right = buildTree(nums, mid + 1, right);

		return root;
	}
}

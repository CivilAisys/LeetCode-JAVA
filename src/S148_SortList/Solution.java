package S148_SortList;

public class Solution {

	/*
	 * 使用 mergeSort(Divide and Conquer)
	 * 概念為將問題分割為子問題 當鏈表元素只有一個的時候就是有序的
	 * */
	public ListNode sortList(ListNode head) {
		// 空或是只有一個  不用排序
		if (head == null || head.next == null) {
			return head;
		}

		// 找到鏈表的中間節點並拆分兩個部分
		ListNode mid = getMiddle(head);
		ListNode left = head;
		ListNode right = mid.next;
		mid.next = null; // 斷開鏈表

		// 遞歸排序兩個部分
		ListNode sortedLeft = sortList(left);
		ListNode sortedRight = sortList(right);
		// 合併兩部分
		return merge(sortedLeft, sortedRight);
	}

	private ListNode getMiddle(ListNode head) {
		if (head == null) {
			return head;
		}
		// 使用快慢指針找到中間
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0); // 虛擬頭節點
		ListNode current = dummy;

		// 合併兩個排序好的鏈表
		while (left != null && right != null) {
			if (left.val <= right.val) {
				current.next = left;
				left = left.next;
			} else {
				current.next = right;
				right = right.next;
			}
			current = current.next;
		}

		// 如果還有剩餘的節點，連接到合併後的鏈表末尾
		if (left != null) {
			current.next = left;
		} else if (right != null) {
			current.next = right;
		}

		return dummy.next;
	}
}

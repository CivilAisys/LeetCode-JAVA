package S86_PartitionList;

public class Solution {

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		// 使用兩個鏈結來分組 並使用虛擬頭節點(dummy head)
		ListNode smallerHead = new ListNode(0); // 小於 x 的鏈結
		ListNode smaller = smallerHead;
		ListNode greaterHead = new ListNode(0); // 大於等於 x 的鏈結
		ListNode greater = greaterHead;

		// 遍歷鏈結
		while (head != null) {
			if (head.val >= x) {
				greater.next = head;
				greater = greater.next;
			} else {
				smaller.next = head;
				smaller = smaller.next;
			}
			head = head.next;
		}
		// 將greaterThan next 設為null 避免循環
		greater.next = null;

		// 兩個分組過的鏈結進行串接
		smaller.next = greaterHead.next;

		return smallerHead.next;
	}
}

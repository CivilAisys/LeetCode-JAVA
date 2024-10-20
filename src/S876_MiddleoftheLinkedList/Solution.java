package S876_MiddleoftheLinkedList;

public class Solution {

	public ListNode middleNode(ListNode head) {
		// 快慢指針
		ListNode slow = head;
		ListNode fast = head;

		// 快指針每次走兩步慢指針走一步
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 快指針到達末尾 慢指針即為中間節點
		return slow;
	}
}

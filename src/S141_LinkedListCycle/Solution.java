package S141_LinkedListCycle;

public class Solution {

	/**
	 * 使用快慢指針
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;

		// 初始化快慢指針
		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != fast) {
			if (fast == null || fast.next == null)
				return false;

			slow = slow.next;
			fast = fast.next.next;
		}

		return true;
	}
}


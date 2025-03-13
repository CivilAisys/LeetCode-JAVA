package S203_RemoveLinkedListElements;

public class Solution {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;

		// 使用虛擬頭節點
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy; // 用來遍歷鏈表

		// 遍歷鏈表 比對下一個節點是否等於val
		while (current.next != null) {
			if (current.next.val == val) {
				current.next = current.next.next;
				continue;
			}
			// 右移
			current = current.next;
		}
		return dummy.next;
	}
}

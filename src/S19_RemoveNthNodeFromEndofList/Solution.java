package S19_RemoveNthNodeFromEndofList;

public class Solution {

	/**
	 * 使用快慢指針  其中一個向前移n 接著遍歷到最後 那麼就是要移除的node了
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head; // 使用dummy保存head節點

		// 快慢指針皆指向dummy
		ListNode first = dummy;
		ListNode second = dummy;

		// 先讓first 向前移n
		for (int i = 0; i < n; i++) {
			first = first.next;
		}

		// 開始遍歷
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}
		// 此時second的下一個就是要刪除的節點了
		second.next = second.next.next;

		return dummy.next;
	}
}

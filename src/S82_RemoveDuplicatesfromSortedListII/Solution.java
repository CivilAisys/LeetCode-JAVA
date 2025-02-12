package S82_RemoveDuplicatesfromSortedListII;

public class Solution {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode dummy = new ListNode(0, head); // 虛擬頭節點 方便處理
		ListNode prev = dummy; // prev 指向上ㄧ個非重複節點
		ListNode current = head;

		while (current != null) {
			// 檢查是否有重複節點
			boolean isDuplicate = false;
			while (current.next != null && current.val == current.next.val) {
				isDuplicate = true;
				current = current.next; // 跳過重複節點
			}

			if (isDuplicate) {
				prev.next = current.next; // 跳過所有重複節點 當前current為重複的最後一個節點
			} else {
				prev = prev.next;    // 保持 prev 連接當前節點
			}

			current = current.next;
		}

		return dummy.next;
	}

}

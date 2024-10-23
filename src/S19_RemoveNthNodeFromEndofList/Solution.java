package S19_RemoveNthNodeFromEndofList;

public class Solution {

	/**
	 * 使用快慢指針  其中一個向前移n 接著遍歷到最後 那麼就是要移除的node了
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 創建一個虛擬頭節點，指向head
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// 初始化兩個指針
		ListNode fast = dummy;
		ListNode slow = dummy;

		// 將 fast 指針向前移動 n + 1 步，這樣 fast 和 slow 之間的距離是 n + 1
		for (int i = 0; i < n + 1; i++) {
			fast = fast.next;
		}

		// 同時移動 fast 和 slow，直到 fast 到達鏈表末尾
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		// 此時 slow 的下一個節點是要刪除的節點
		slow.next = slow.next.next;

		// 返回新的鏈表頭，dummy.next 是原始鏈表的頭節點（除非第一個節點被刪除）
		return dummy.next;
	}
}

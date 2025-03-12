package S147_InsertionSortList;

public class Solution {

	public ListNode insertionSortList(ListNode head) {
		// 虛擬頭節點 作為排序後的鏈結起點
		ListNode dummy = new ListNode(0);

		ListNode cur = head; // 尚未排序的部分
		// cur == null 代表全部已排序完成
		while (cur != null) {
			ListNode nextTemp = cur.next; // 先保存下個節點  避免插入後遺失

			// 從dummy開始找插入位置
			ListNode prev = dummy;
			while (prev.next != null && prev.next.val < cur.val) {
				prev = prev.next;
			}

			// 插入cur到prev之後
			cur.next = prev.next;
			prev.next = cur;

			cur = nextTemp;
		}

		return dummy.next;
	}
}

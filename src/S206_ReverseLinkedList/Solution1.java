package S206_ReverseLinkedList;

public class Solution1 {
	// 使用遞歸
	public ListNode reverseList(ListNode head) {
		// 基本情況：當鏈表為空或只有一個節點時，直接返回該節點
		if (head == null || head.next == null) {
			return head;
		}

		// 遞歸反轉子鏈表
		ListNode newHead = reverseList(head.next);

		// 將當前節點接到反轉後的鏈表尾部並將當前節點與next斷開
		head.next.next = head;
		head.next = null;

		// 返回新的頭節點
		return newHead;
	}
}

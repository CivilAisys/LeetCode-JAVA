package S206_ReverseLinkedList;

public class Solution {
	// 使用迭代
	public ListNode reverseList(ListNode head) {
		ListNode prev = null; // 前一節點
		ListNode current = head; // 當前節點

		// 遍歷鏈表
		while(current != null){
			ListNode next = current.next; // 保存下一個節點
			current.next = prev; // 當前節點指向prev
			prev = current; // 前一節點向後移
			current = next; // 當前節點後移
		}

		//最後 prev 就是頭節點
		return prev;
	}
}

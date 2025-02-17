package S92_ReverseLinkedListII;

public class Solution {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		// 使用虛擬頭節點 (dummy head)
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 先找到 pre(反轉前的節點)
		ListNode pre = dummy;
		for (int i = 1; i < left; i++) {
			pre = pre.next;
		}

		// start(反轉的第一個節點) then為要移動到頭的節點
		ListNode start = pre.next;
		ListNode then = start.next;
		// 使用頭插法(節點插入頭來達成反轉) then 插入頭
		for (int i = 0; i < right - left; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		return dummy.next;
	}
}

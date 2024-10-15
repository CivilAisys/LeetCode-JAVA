package S328_OddEvenLinkedList;

public class Solution {

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode odd = head; // 奇數節點
		ListNode even = head.next; // 偶數節點
		ListNode evenHead = even; // 偶數節點的頭

		while (even != null && even.next != null) {
			// 奇數節點連接並向後移動
			odd.next = even.next;
			odd = odd.next;

			// 偶數節點連結並向後移動
			even.next = odd.next;
			even = even.next;
		}

		odd.next = evenHead; // 將偶數部分連結到奇數的末尾
		return head;
	}
}

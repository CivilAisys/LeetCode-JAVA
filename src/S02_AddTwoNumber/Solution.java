package S02_AddTwoNumber;

public class Solution {

	public static class ListNode {

		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode head = result; //用於指針移動
		int carry = 0; //進位值

		while (l1 != null || l2 != null || carry != 0) {
			int sum = carry; //將sum 初始為進位值

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10; //carry為int 故小數點會被截斷
			sum %= 10; // 保留個位數

			//創建新的ListNode並移動head
			head.next = new ListNode(sum);
			head = head.next;
		}
		return result.next; // result為空節點 故須回傳result.next
	}

}

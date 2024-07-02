package S143_ReorderList;

public class Solution {

	public void reorderList(ListNode head) {
		if (head.next == null)
			return;

		// 使用快慢指針找到中間節點
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 反轉鏈表後半部分
		ListNode prev = null, curr = slow, temp;
		while (curr != null) {
			temp = curr.next; // 用於在改變curr.next時還可以訪問到
			curr.next = prev; // 反轉
			prev = curr; // 將prev右移
			curr = temp; // curr右移
		}

		// 合併前後部分 prev為鏈表尾部
		ListNode first = head, second = prev;
		while (second.next != null) {
			temp = first.next;
			first.next = second;
			first = temp;

			temp = second.next;
			second.next = first;
			second = temp;
		}
	}
}

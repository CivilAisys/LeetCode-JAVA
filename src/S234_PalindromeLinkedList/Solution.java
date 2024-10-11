package S234_PalindromeLinkedList;

public class Solution {

	public boolean isPalindrome(ListNode head) {
		if (head.next == null) {
			return true; // 只有一個節點的鏈表就是回文
		}

		// 1. 使用快慢指針找到鏈表中點
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 2.鏈表長度為奇數  跳過中間節點(不用處理)
		if (fast != null) {
			slow = slow.next;
		}

		// 3.反轉後半鏈表
		ListNode secondHalfStart = reverseList(slow);

		// 4. 比較前半部分和反轉後的後半部分
		ListNode firstHalfStart = head;

		while (secondHalfStart != null) {
			if (firstHalfStart.val != secondHalfStart.val) {
				return false;
			}
			firstHalfStart = firstHalfStart.next;
			secondHalfStart = secondHalfStart.next;
		}

		return true;
	}

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		while (current != null) {
			ListNode nextTemp = current.next;
			current.next = prev;
			prev = current;
			current = nextTemp;
		}
		return prev; // prev 是反轉後的頭節點
	}
}

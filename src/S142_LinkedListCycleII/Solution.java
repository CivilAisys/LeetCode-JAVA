package S142_LinkedListCycleII;

public class Solution {

	// 使用 Floyd's Cycle Detection Algorithm
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		// 1. 快慢指針判斷是否有環
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;

			// 相遇時 將 slow 放回head 接著兩個指針一起走每次一步 相遇即為環的起點
			if(slow == fast){
				slow = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}

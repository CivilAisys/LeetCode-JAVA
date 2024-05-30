package S21_MergeTwoSortedLists;

public class Solution {

	/**
	 * 遍歷兩個鏈表比大小進行合併
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode merge = new ListNode(0); //合併的鏈表
		ListNode dummy = merge; // 最後返回dummy.next即可

		// 鏈表每個端點進行比大小合併
		while (list1 != null && list2 != null) {
			int val1 = list1.val;
			int val2 = list2.val;

			if (val1 <= val2) {
				merge.next = new ListNode(val1);
				list1 = list1.next;
			} else {
				merge.next = new ListNode(val2);
				list2 = list2.next;
			}

			merge = merge.next; // 移動合併的鏈表
		}

		// 需要考慮長度不一致的情況  並將剩餘的都加到合併後的鏈表尾部
		if (list1 != null) {
			merge.next = list1;
		} else {
			merge.next = list2;
		}

		return dummy.next;
	}
}

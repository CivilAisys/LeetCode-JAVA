package S160_IntersectionofTwoLinkedLists;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	// 使用set來輔助 空間複雜度為O(m) or O(n) 時間複雜度為O(m+n)
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// 使用set來確認對應node是否有重複出現
		Set<ListNode> visitedNode = new HashSet<>();
		// 先加入鏈表A的節點
		while (headA != null) {
			visitedNode.add(headA);
			headA = headA.next;
		}
		// 確認鏈表B內是否有重複節點
		while (headB != null) {
			if (visitedNode.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}

		return null;
	}
}

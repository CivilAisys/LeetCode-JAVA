package S83_RemoveDuplicatesfromSortedList;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode current = head;

        // 遍歷鏈表
        while(current != null && current.next != null){
            if(current.val == current.next.val){
                // 重複 將下個節點替換成下下個節點
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}

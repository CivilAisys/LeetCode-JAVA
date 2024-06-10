package S61_RotateList;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1.計算鏈表長度
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // 2.計算有效旋轉次數
        k = k % length;
        if (k == 0) {
            return head;
        }

        // 3.用雙指針找到新的頭尾
        ListNode slow = head;
        ListNode fast = head;
        // 先移動快指針
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 快慢指針一起移動
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 4. 斷開並重新連結鏈表
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}

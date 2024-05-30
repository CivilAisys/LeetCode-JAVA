package S24_SwapNodesinPairs;

public class Solution {

    /**
     * 使用遞迴來調換節點
     */
    public ListNode swapPairs(ListNode head) {
        // 當前節點或下一個節點為null時不用調換
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next; // 保存下個節點
        head.next = swapPairs(second.next); // 將當前節點的next指向遞歸調用的結果
        second.next = head; // 將當前節點指向 second.next完成節點調換

        return second; // 此時second已經完成調換為前面的節點
    }
}

package S117_PopulatingNextRightPointersinEachNodeII;

public class Solution {
	public Node connect(Node root) {
		if (root == null) return null;

		Node levelStart = root; // 當前層的最左節點

		while (levelStart != null) { // 當還有下一層時
			Node dummyHead = new Node(0); // 虛擬頭節點，幫助連接下一層的 `next`
			Node prev = dummyHead; // 指向下一層的最後一個連接的節點

			Node curr = levelStart; // 遍歷當前層的節點
			while (curr != null) {
				if (curr.left != null) { // 連接左子節點
					prev.next = curr.left;
					prev = prev.next; // 更新 prev
				}
				if (curr.right != null) { // 連接右子節點
					prev.next = curr.right;
					prev = prev.next; // 更新 prev
				}
				curr = curr.next; // 移動到該層的下一個節點
			}

			// 移動到下一層的最左節點
			levelStart = dummyHead.next;
		}

		return root;
	}
}

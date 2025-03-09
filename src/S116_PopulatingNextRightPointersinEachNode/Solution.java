package S116_PopulatingNextRightPointersinEachNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	// 解法1 使用層序遍歷
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		// 使用queue輔助層序遍歷
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size(); // 當層節點數

			for (int i = 0; i < levelSize; i++) {
				Node currentNode = queue.poll();
				// 不是最右節點要設置next
				if (i < levelSize - 1) {
					currentNode.next = queue.peek();
				}

				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
		}
		return root;
	}

	// 解法 2 Next Pointers Traversal 只使用O(1)空間
	public Node connect1(Node root){
		if (root == null) return null;

		Node levelStart = root; // 當前層的最左節點

		while (levelStart.left != null) { // 當還有下一層時
			Node curr = levelStart; // 遍歷當前層

			while (curr != null) { // 遍歷該層的所有節點
				// 連接左右子節點
				curr.left.next = curr.right;

				// 連接跨父節點的子節點
				if (curr.next != null) {
					curr.right.next = curr.next.left;
				}

				// 移動到該層的下一個節點
				curr = curr.next;
			}

			// 移動到下一層的最左節點
			levelStart = levelStart.left;
		}
		return root;
	}

}

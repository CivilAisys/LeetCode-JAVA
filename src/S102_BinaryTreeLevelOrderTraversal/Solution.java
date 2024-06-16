package S102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * 使用BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        // 使用queue來輔助遍歷 並將root加入
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 層序遍歷 每次queue中的起始元素就為該層的元素數量
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 當層節點數量
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // 取出當前層的節點
                currentLevel.add(currentNode.val); // 加入當前層的結果列表

                // 將當前節點的左右節點加入queue中待下一層遍歷
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }
}

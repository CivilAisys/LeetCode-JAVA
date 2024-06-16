package S144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * 前序 順序為 根節點 -> 左子節點 -> 右子節點
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        // 中止條件
        if (node == null)
            return;

        //將當前節點加入到結果中 
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    /**
     * 使用迭代
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        // 使用Stack輔助
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 遍歷
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val); // 重要  因為前序遍歷順序是 根->左->右

            // 先將右子樹壓入stack中  這樣左子樹會比右子樹還要先進行處理
            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }

}

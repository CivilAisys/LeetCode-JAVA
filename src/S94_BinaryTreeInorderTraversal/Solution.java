package S94_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    /*
     * inorder(中序) 的順序為 左子樹 -> 根結點 -> 右子樹
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    /**
     * 輔助dfs函式
     */
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderHelper(node.left, result); // 先左子樹
            result.add(node.val); // 左子樹遍歷完將當前節點加入
            inorderHelper(node.right, result); // 再右子樹
        }
    }

    /**
     * 使用迭代 
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>(); // 使用stack來輔助
        TreeNode current = root;

        // 當前節點非空 或是stack內還有值
        while (current != null || !stack.isEmpty()) {

            // 將所有左子節點壓入棧中
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 當左子節點遍歷完 從棧中彈出並加入到result中
            current = stack.pop();
            result.add(current.val);

            // 轉向右子節點
            current = current.right;
        }

        return result;
    }
}

package S145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * 後序 順序為 左->右->根 使用遞迴
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if(node == null) return;
        // 順序為 左 -> 右 -> 根
        postorder(node.left, result);  // 訪問左子樹
        postorder(node.right, result); // 訪問右子樹
        result.add(node.val);          // 訪問根節點
    }



    /**
     * 使用迭代
     */
    public List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>(); // 塞入的順序為 根 -> 右 -> 左 彈出的順序就是 左 -> 右 -> 根
        stack.push(root);
        // 加入output的順序為根 右 左 逆序處理就是後續的 左 右 根
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node);

            if (node.left != null) {
                stack.push(node.left); // 先將左子樹壓入堆疊
            }
            if (node.right != null) {
                stack.push(node.right); // 再將右子樹壓入堆疊
            }
        }

        while (!output.isEmpty()) {
            result.add(output.pop().val); // 從輸出堆疊中彈出
        }

        return result;
    }
}

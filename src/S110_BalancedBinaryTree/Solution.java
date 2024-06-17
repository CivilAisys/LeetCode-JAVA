package S110_BalancedBinaryTree;

public class Solution {

    /**
     * 使用dfs  高度平衡二叉樹定義為任一個節點的左右子樹高度差不超過1
     */
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        // 空節點 高度為零
        if (node == null)
            return 0;
        // 檢查左子樹 不平衡返回-1
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1)
            return -1;
        // 檢查右子樹
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1)
            return -1;

        // 檢查左右子樹高度差是否超過1
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        // 若都平衡  返回當前節點高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

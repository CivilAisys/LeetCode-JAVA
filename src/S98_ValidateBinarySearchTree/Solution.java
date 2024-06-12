package S98_ValidateBinarySearchTree;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return helperFunction(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helperFunction(TreeNode node, Long low, Long high) {
        // 終止條件
        if (node == null) {
            return true;
        }
        // 超過區間
        if (node.val <= low || node.val >= high) {
            return false;
        }
        // 遞迴驗證左右子樹
        return helperFunction(node.left, low, (long) node.val) && helperFunction(node.right, (long) node.val, high);
    }
}

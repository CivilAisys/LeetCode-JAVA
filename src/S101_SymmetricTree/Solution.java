package S101_SymmetricTree;

public class Solution {

    /**
     * 使用遞迴
     */
    public boolean isSymmetric(TreeNode root) {
        //  遞迴檢查左右子樹是否對秤
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // 兩子樹皆空代表對稱
        if (t1 == null && t2 == null)
            return true;

        // 一子樹不為空 不對稱
        if (t1 == null || t2 == null)
            return false;

        // 遞迴調用檢查當前節點的直 還有左右子樹是否都對秤
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

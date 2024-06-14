package S100_SameTree;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;
        // 遞迴遍歷左右子樹
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

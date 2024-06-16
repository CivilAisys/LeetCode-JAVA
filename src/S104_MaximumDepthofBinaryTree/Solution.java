package S104_MaximumDepthofBinaryTree;

public class Solution {

    /**
     * 使用dfs計算最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        //計算左右子樹最大深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // 返回左子樹和右子樹最大深度的較大者，再加上1（包括當前節點的深度）
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

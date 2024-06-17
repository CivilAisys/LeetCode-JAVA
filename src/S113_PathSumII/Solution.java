package S113_PathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 使用 backtracking
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode node, int sum, List<Integer> current, List<List<Integer>> result) {
        // 中止條件
        if (node == null)
            return;

        current.add(node.val);

        // 檢查是否為葉節點(沒有左右子樹 且val等於目標和)
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList<>(current));
        } else {
            // 遍歷左右子樹
            findPaths(node.left, sum - node.val, current, result);
            findPaths(node.right, sum - node.val, current, result);
        }

        // 回溯，移除當前節點
        current.remove(current.size() - 1);
    }
}

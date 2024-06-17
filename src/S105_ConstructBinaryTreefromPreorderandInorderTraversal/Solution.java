package S105_ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, Integer> inorderIndexMap; // 用來存放中序遍歷中節點對應的索引

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序遍歷中 根節點為第一個元素
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 找到根節點在中序遍歷中的索引
        int rootIndex = inorderIndexMap.get(rootVal);

        // 計算左子樹大小  前中序遍歷順序為左 -> 根 -> 右  
        // 故在找尋到根節點情況下可以知道左右子樹大小
        int leftSize = rootIndex - inStart;

        // 遞迴構建左右子樹
        // preStart + 1代表前序中下個左子樹的起始 preStart + leftSize 代表左子樹的終點
        // inStart 不變 因為根節點劃分左右 inEnd = rootIndex - 1代表左子樹再中序中的終點
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
        // preStart + leftSize + 1 為前序中下個右子樹的起始 印為前序的順序為 根 -> 左 -> 右
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }

}

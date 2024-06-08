package S54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        // 使用上下左右邊界索引來進行移動
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        //遍歷
        while (top <= bottom && left <= right) {
            // 從左到右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // top下移

            //從右上到右下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // right左移

            // top 下移需要檢查 不然可能會有邊界錯誤
            if (top <= bottom) {
                // 從右到左
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // bottom下移
            }

            // right 左移需要檢查 也可能有邊界錯誤
            if (left <= right) {
                // 從下到上
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // left右移
            }
        }

        return result;
    }
}

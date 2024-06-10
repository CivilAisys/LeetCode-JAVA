package S59_SpiralMatrixII;

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n]; // 要填充的矩陣
        int num = 1; // 從1開始填充
        int left = 0, right = n - 1, top = 0, bottom = n - 1; // 上下左右索引

        while (left <= right && top <= bottom) {
            // 從左到右填充
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;

            }
            top++; // top下移

            // 填充上到下
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;

            }
            right--; // right左移

            //從右到左填充
            if (top <= bottom) { // 可能只有一列 故需要檢查 不然會有越界可能
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;

                }
                bottom--; // bottom上移
            }

            //從下到上
            if (left <= right) { // 可能只有一行 故需要檢查不然會有越界或重複加入可能
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++; // left右移
            }
        }

        return matrix;
    }
}

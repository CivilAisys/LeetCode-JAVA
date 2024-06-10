package S73_SetMatrixZeroes;

public class Solution {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 紀錄需要設置為0的行列
        boolean[] rowsZeroes = new boolean[rows];
        boolean[] colsZeroes = new boolean[cols];

        // 第一次遍歷矩陣  標記出需要設值為0的行跟列
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowsZeroes[i] = true;
                    colsZeroes[j] = true;
                }
            }
        }

        // 第二次遍歷矩陣 將需要設置為0的行列元素設置為0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowsZeroes[i] || colsZeroes[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

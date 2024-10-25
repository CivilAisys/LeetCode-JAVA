package S48_RotateImage;

public class Solution {

    /**
     * 要將圖片進行90度翻轉 先進行1.轉置矩陣 2. 行翻轉
     * 時間 O(n * n) 空間 O(1)
     */
    public void rotate(int[][] matrix) {
        int matrixLength = matrix.length;

        // 轉置矩陣
        for (int i = 0; i < matrixLength; i++) {
            for (int j = i; j < matrixLength; j++) { // j 從 i 開始 如果從0 開始。同一個元素會被交換兩次變成沒有變化
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 行翻轉
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength / 2; j++) { // 只需要翻轉到中間位置即可
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrixLength - 1 - j]; // 需要 -1是因為矩陣邊長從1開始，矩陣索引從0開始
                matrix[i][matrixLength - 1 - j] = temp;
            }
        }
    }
}

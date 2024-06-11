package S79_WordSearch;

public class Solution {

    /**
     * 使用dfs來從每一個字元開始
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 中止條件
        if (index == word.length()) {
            return true;
        }

        // 越界或非該對應字母
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // 標記為訪問過  避免重複使用
        // 上下左右尋找
        boolean found = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) || dfs(board,
            word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // 回溯，恢復原始值

        return found;
    }
}

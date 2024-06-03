package S36_ValidSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        // 儲存列.行.九宮格內的數字用於比對
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();

        // 初始化set
        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            boxes.put(i, new HashSet<>());
        }

        // 遍歷數獨
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num == '.') {
                    continue;
                }
                // 計算方格索引 0 ~ 8 需要*3是因為每列有三個
                int boxIndex = (i / 3) * 3 + j / 3;
                // 取得的數必須在列.行.九宮格內都沒有 不然就不符合
                if (rows.get(i).contains(num) || cols.get(j).contains(num) || boxes.get(boxIndex).contains(num)) {
                    return false;
                }

                // 將當前數塞入對應的列.行.九宮格內
                rows.get(i).add(num);
                cols.get(j).add(num);
                boxes.get(boxIndex).add(num);
            }
        }
        return true;
    }
}

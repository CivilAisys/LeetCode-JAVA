package S22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 使用backtracking來列出所有可能
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAllCombination(result, "", 0, 0, n);
        return result;
    }

    private void generateAllCombination(List<String> result, String current, int open, int close, int max) {
        // 結束條件 為current長度等於 max * 2 表示左右括弧數量一致
        if (current.length() == max * 2) {
            result.add(current);
        }

        // 左括弧
        if (open < max) {
            generateAllCombination(result, current + "(", open + 1, close, max);
        }
        // 右括弧
        if (close < open) {
            generateAllCombination(result, current + ")", open, close + 1, max);
        }
    }

}

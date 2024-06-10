package S58_LengthofLastWord;

public class Solution {

    /**
     * 從後面向前遍歷找到最後一個字串
     */
    public int lengthOfLastWord(String s) {
        s = s.trim(); // 將前後空白去除
        int length = 0; // 結果的長度

        // 從後向前遍歷
        for (int i = s.length() - 1; i >= 0; i--) {
            // 遇到空白代表最後一個字串結束
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }

        return length;
    }
}

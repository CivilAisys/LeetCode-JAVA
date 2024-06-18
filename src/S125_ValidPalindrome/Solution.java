package S125_ValidPalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        // 將字串轉為小寫並初始化雙指針
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // 跳過非字母數字的字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // 比對左右字符是否相等
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

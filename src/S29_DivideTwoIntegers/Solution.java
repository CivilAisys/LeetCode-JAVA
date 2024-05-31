package S29_DivideTwoIntegers;

public class Solution {

    public int divide(int dividend, int divisor) {
        // 溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 判斷結果正負號 使用異與 只要一者為1 結果就為1
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // 將被除數和除數轉換為負數，避免溢出
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        int result = 0; // 商數
        // 使用位移操作來逐步逼近商的結果
        while (absDividend - absDivisor >= 0) {
            int tempDivisor = absDivisor, multiple = 1; // multiple 為倍數
            while (absDividend - (tempDivisor << 1) >= 0) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            absDividend -= tempDivisor; // 被除數減對應倍數的除數
            result += multiple;
        }

        return isNegative ? -result : result;
    }
}

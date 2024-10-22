package S07_ReverseInteger;

public class Solution {

	/**
	 * java int會溢出
	 */
	public int reverse(int x) {
		int reversed = 0; // 反轉後的值

		while (x != 0) {
			int digit = x % 10; // 取得個位數
			x /= 10; // 除10移除個位數

			// 在轉換前檢查是否會溢出
			if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
				return 0; // 溢出返回0
			}
			if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
				return 0; // 溢出返回0
			}

			reversed = reversed * 10 + digit; // 轉換
		}

		return reversed;
	}

}

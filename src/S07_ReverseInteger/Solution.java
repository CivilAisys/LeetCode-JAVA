package S07_ReverseInteger;

public class Solution {

	/**
	 * java int會溢出
	 */
	public int reverse(int x) {
		int num = Math.abs(x); // 先轉換成正整數 在最後在處理正負
		int reversed = 0; // 反轉後的值

		while (num != 0) {
			int digit = num % 10; //取得個位數
			num /= 10; // 除10移除個位數

			// 在轉換前檢查是否會溢出
			if (reversed > (Integer.MAX_VALUE - digit) / 10) {
				return 0;
			}
			reversed = reversed * 10 + digit; // 轉換
		}

		return x < 0 ? -reversed : reversed;
	}

}

package S08_StringtoInteger;

public class Solution {

	/**
	 * 1.讀取前導空白
	 * 2.讀取是否有'-' or '+'
	 * 3.讀取下一字元直到碰到非數值的字元或是結尾
	 * 4.數值須將開頭有0去除
	 * 5.數值不可超過界線*
	 */
	public int myAtoi(String s) {
		s = s.trim(); // 去除前導空白
		// 邊界檢查
		if (s.length() == 0)
			return 0;

		int sign = 1; // 正負號
		int index = 0; // 當前索引
		long result = 0; // 使用long 防止數值溢出

		char firstChar = s.charAt(index); //
		// 檢查正負號
		if (firstChar == '+' || firstChar == '-') {
			sign = firstChar == '-' ? -1 : 1;
			index++;
		}

		// 遍歷字串
		while (index < s.length()) {
			char currentChar = s.charAt(index);

			if (!Character.isDigit(currentChar))
				break; // 非數值直接break

			result = result * 10 + (currentChar - '0'); // char 加減計算使用ascII碼值 故需要扣掉0的值

			// 檢查是否溢出
			if (sign * result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			if (sign * result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;

			index++;
		}

		return (int) result * sign;
	}
}

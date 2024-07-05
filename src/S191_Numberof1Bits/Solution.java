package S191_Numberof1Bits;

public class Solution {

	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			// 使用按位與操作檢查最低位是否為1
			count += (n & 1);
			// 右移一位 >>> 高位補0
			n = n >>> 1;
		}
		return count;
	}
}

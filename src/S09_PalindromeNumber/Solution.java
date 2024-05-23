package S09_PalindromeNumber;

public class Solution {

	/**
	 * 將數字進行反轉後進行比較是否一致
	 */
	public boolean isPalindrome(int x) {
     	// 負數一定不為回文
     	if (x < 0)
     		return false;

     	int original = x; // 保存原始數字
     	int reversed = 0;

     	while(x != 0){
     		int digit = x % 10; // 取得個位數
     		x /= 10; // 減少一個位數

     		reversed = reversed * 10 + digit;
     	}
     	// 比較反轉後是否相同
     	return reversed == original;
    }
}

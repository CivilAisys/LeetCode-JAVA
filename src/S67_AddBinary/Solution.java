package S67_AddBinary;

public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // 進位值

        // 從右到左進行相加
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }

        // 相加完需要檢查進位值是否不為0
        if (carry != 0) {
            result.append(carry);
        }

        // 因為是從右向左相加 實際結果須反轉
        return result.reverse().toString();
    }
}

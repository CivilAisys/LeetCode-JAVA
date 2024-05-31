package S28_FindtheoftheFirstOccurrenceinaString;

public class Solution {

    public int strStr(String haystack, String needle) {
        // 遍歷 haystack
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // 比對haystack and needle
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i; //走到裡面到代表比對完成
                }
            }
        }
        return -1;
    }
}

package S131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		backtrack(s, 0, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
		// 當 start 到達字串尾端，代表已成功切割
		if (start == s.length()) {
			result.add(new ArrayList<>(path)); // 加入結果集
			return;
		}

		// 嘗試所有可能的切割點
		for (int end = start; end < s.length(); end++) {
			if (isPalindrome(s, start, end)) { // 只有當是回文時才繼續遞迴 因為結果中不能有非回文字串
				path.add(s.substring(start, end + 1)); // 加入
				backtrack(s, end + 1, path, result);  // 遞迴
				path.remove(path.size() - 1); // 回溯
			}
		}
	}

	private boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}

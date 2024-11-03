package S692_TopKFrequentWords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	public List<String> topKFrequent(String[] words, int k) {
		// 1.統計每個單字出現的次數
		Map<String, Integer> countMap = new HashMap<>();
		for (String word : words) {
			countMap.put(word, countMap.getOrDefault(word, 0) + 1);
		}

		// 2.使用優先佇列來儲存前k個高頻單字 頻率相同 使用compareTo比較字母順序
		// 使用 w2.compareTo(w1) 是因為題目要求按照頻率高到低排序 頻率一樣字典順序小的先
		PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> countMap.get(w1).equals(countMap.get(w2))
			? w1.compareTo(w2)
			: countMap.get(w2) - countMap.get(w1));

		// 3.將每個單字加入堆中  使用最大堆  故前k個舊式結果
		for (String word : countMap.keySet()) {
			heap.offer(word);
		}
		// 4.取前k個
		List<String> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(heap.poll());
		}

		return result;
	}
}

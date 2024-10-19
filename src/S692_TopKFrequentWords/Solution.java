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
		// 且因為使用最小堆  最後會反轉 所以需要使用 w2.compareTo(w1)
		PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> countMap.get(w1).equals(countMap.get(w2))
			? w2.compareTo(w1)
			: countMap.get(w1) - countMap.get(w2));

		// 3.將每個單字加入堆中  並保持堆的大小為k
		for (String word : countMap.keySet()) {
			heap.offer(word);
			if (heap.size() > k) {
				heap.poll(); // 移除堆頂的最小值 保持堆中只有k個元素
			}
		}

		// 4. 反轉結果，因為小頂堆的順序是從小到大，所以需要反轉順序
		List<String> result = new ArrayList<>();
		while (!heap.isEmpty()) {
			result.add(heap.poll());
		}
		Collections.reverse(result); // 反轉，得到最終結果

		return result;
	}
}

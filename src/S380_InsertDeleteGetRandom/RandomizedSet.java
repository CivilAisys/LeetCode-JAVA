package S380_InsertDeleteGetRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

	private Map<Integer, Integer> map; // 儲存值 -> 索引的映射
	private List<Integer> list; // 用來存放元素來支援隨機存取
	private Random random;

	public RandomizedSet() {
		map = new HashMap<>();
		list = new ArrayList<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}

		map.put(val, list.size());
		list.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		// list 移除時會有元素移動的問題 需要先更新刪除索引所在元素在刪除尾部元素
		int index = map.get(val);
		int lastElement = list.get(list.size() - 1);

		list.set(index, lastElement); // 將要刪除的索引的元素更新為最後一個元素
		map.put(lastElement, index); // 更新最後一個元素的索引

		list.remove(list.size() - 1); // 刪除最後一個元素
		map.remove(val); // 從 map 移除 val

		return true;
	}

	public int getRandom() {
		int randomIndex = random.nextInt(list.size());
		return list.get(randomIndex);
	}
}

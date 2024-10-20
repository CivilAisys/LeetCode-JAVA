package S981_TimeBasedKeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

	// HashMap 每個 key 對應一個 TreeMap，TreeMap 的鍵是時間戳，值是存儲的 value
	private Map<String, TreeMap<Integer, String>> map;

	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		// key 不存在初始化
		map.putIfAbsent(key, new TreeMap<>());
		// 將時間戳和對應的值存入TreeMap中
		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		// key不存在  返回空字串
		if (!map.containsKey(key)) {
			return "";
		}

		// 使用 TreeMap 的 floorEntry 方法找到 <= timestamp 的最大鍵
		Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);

		// 如果 entry 為 null，表示沒有符合條件的時間戳，返回空字串
		if (entry == null) {
			return "";
		}

		// 否則返回對應的值
		return entry.getValue();
	}
}

package S49_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * 將字元進行排序後當作map的key來分組
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // 遍歷strs
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray); // 關鍵  需要排序才能確保key一致
            String sortedStr = new String(charArray);
            // 排序後的字串不再map中就創建一組
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<String>());
            }

            map.get(sortedStr).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }
}

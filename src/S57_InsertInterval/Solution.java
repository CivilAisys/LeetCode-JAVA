package S57_InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        // 添加所有在 newInterval 前的區間
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // 合併重疊的區間
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            // 更新newInterval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }   
        result.add(newInterval); // 將合併的區間加入到結果中

        // 剩餘結果加入
        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}

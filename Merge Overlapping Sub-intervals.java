import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Sort by starting time
        
        List<List<Integer>> li = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;

            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            li.add(Arrays.asList(start, end));
            i = j;
        }

        int[][] res = new int[li.size()][2];
        for (int j = 0; j < li.size(); j++) {
            res[j][0] = li.get(j).get(0);
            res[j][1] = li.get(j).get(1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        int[][] merged = obj.merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] arr : merged) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

// LeetCode 2965 :https://leetcode.com/problems/find-missing-and-repeated-values/description/
import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m = grid.length;
        int n = m * m;

        long sn = (long)n * (n + 1) / 2;
        long sn2 = (long)n * (n + 1) * (2L * n + 1) / 6;

        long s = 0, s2 = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                s += grid[i][j];
                s2 += (long)grid[i][j] * grid[i][j];
            }
        }

        long v1 = s - sn;      // x - y
        long v2 = s2 - sn2;    // x^2 - y^2

        v2 = v2 / v1;          // x + y

        long x = (v1 + v2) / 2; // repeated
        long y = x - v1;        // missing

        return new int[]{(int)x, (int)y};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // size of grid
        int[][] grid = new int[m][m];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        Solution obj = new Solution();
        int[] ans = obj.findMissingAndRepeatedValues(grid);

        System.out.println(ans[0] + " " + ans[1]); // print repeated then missing
    }
}

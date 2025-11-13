//34. Find First and Last Position of Element in Sorted Array
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] res = sol.searchRange(nums, target);
        System.out.println(Arrays.toString(res));   // Output: [3, 4]
    }
}

class Solution {
    public int first(int[] nums, int t){
        int l = 0, r = nums.length - 1, ans = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] >= t)
                r = m - 1;
            else
                l = m + 1;

            if (nums[m] == t)
                ans = m;
        }
        return ans;
    }

    public int last(int[] nums, int t){
        int l = 0, r = nums.length - 1, ans = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] <= t)
                l = m + 1;
            else
                r = m - 1;

            if (nums[m] == t)
                ans = m;
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{ first(nums, target), last(nums, target) };
    }
}

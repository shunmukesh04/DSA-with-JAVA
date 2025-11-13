//Leetcoce 33. Search in Rotated Sorted Array
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int ans = sol.search(nums, target);
        System.out.println(ans);  // Output: 4
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return m;

            // Left half sorted
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            }

            // Right half sorted
            else {
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}

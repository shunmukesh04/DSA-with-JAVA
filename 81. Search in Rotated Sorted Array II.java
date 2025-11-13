//81. Search in Rotated Sorted Array II
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;

        boolean ans = sol.search(nums, target);
        System.out.println(ans);  // Output: true
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return true;

            // Case 1: when left, mid, right are equal → cannot decide → shrink
            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                l++;
                r--;
            }

            // Case 2: left half sorted
            else if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target <= nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            }

            // Case 3: right half sorted
            else {
                if (nums[m] <= target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
        }
        return false;
    }
}

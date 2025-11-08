import java.util.*;

public class Solution 
{        
    public static int lengthOfLongestSubarray(int[] arr) 
    {
        // HashMap stores: prefixSum -> first index where this sum occurred
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        int maxLen = 0; // Longest subarray length
        int sum = 0;    // Prefix sum

        for (int r = 0; r < n; r++) {
            sum += arr[r]; // Update prefix sum

            // If prefix sum is 0, subarray from index 0 to r has sum 0
            if (sum == 0) 
                maxLen = r + 1;

            // If prefix sum seen before, we found a subarray with sum 0
            if (hm.containsKey(sum)) {
                maxLen = Math.max(maxLen, r - hm.get(sum));
            } 
            else {
                // Store first time this prefix sum appeared
                hm.put(sum, r);
            }
        }
        return maxLen;
    }

    // Main method to test
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // Print result
        System.out.println(lengthOfLongestSubarray(arr));
        
        sc.close();
    }
}

/**
 * PrefixSum
 * Definition: Prefix Sum is a technique in which each index stores the sum of all 
 * elements from the beginning of the array up to that index. It helps answer 
 * range-sum queries efficiently.
 */

import java.util.*;
public class PrefixSum {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int n = arr.length;

        int[] prefix = new int[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        System.out.println(Arrays.toString(prefix));
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
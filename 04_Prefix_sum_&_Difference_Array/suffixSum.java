/**
 * suffixSum
 * Definition: Suffix Sum is a technique in which each index stores the sum of all elements from that index to the end of the array. It helps calculate sums of suffixes efficiently.
 */
import java.util.*;
public class suffixSum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int n = arr.length;

        int[] suffix = new int[n];

        suffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
        }

        System.out.println(Arrays.toString(suffix));
    }
    
}
// Time Complexity: O(n)
// Space Complexity: O(n)
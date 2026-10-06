public class slidingWindow {
    public static int maxSum(int[] arr, int k) {

        int n = arr.length;

        if (n < k) {
            return -1;
        }

        // Calculate sum of first window
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int right = k; right < n; right++) {

            // Remove the element leaving the window
            windowSum -= arr[right - k];

            // Add the new element entering the window
            windowSum += arr[right];

            // Update maximum
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(maxSum(arr, k));
    }
}

/*
| Approach | Time | Space |
|---|---:|---:|
| Brute Force | O(n × k) | O(1) |
| Sliding Window | O(n) | O(1) |

Sliding Window is a technique used to maintain a continuous range (window) of elements in an array or string and move that window efficiently instead of recalculating everything from scratch.
*/

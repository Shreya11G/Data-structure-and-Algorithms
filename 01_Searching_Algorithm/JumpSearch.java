public class JumpSearch {

    public static int jumpSearch(int[] arr, int target) {

        int n = arr.length;

        int jump = (int) Math.sqrt(n);

        int prev = 0;
        int next = jump;

        // Jump through blocks
        while (prev < n && arr[Math.min(next, n) - 1] < target) {
            prev = next;
            next += jump;

            if (prev >= n) {
                return -1;
            }
        }

        // Linear search inside the block
        while (prev < Math.min(next, n)) {

            if (arr[prev] == target) {
                return prev;
            }

            if (arr[prev] > target) {
                return -1;
            }

            prev++;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        int target = 70;

        int index = jumpSearch(arr, target);

        System.out.println("Target found at index: " + index);
    }
}

/*
Jump Search is a searching algorithm used on a sorted array. Instead of checking every element one by one, it jumps ahead by fixed blocks and then performs a linear search inside the block where the target may exist.

| Case         | Time Complexity |
| ------------ | --------------- |
| Best Case    | O(1)            |
| Average Case | O(√n)           |
| Worst Case   | O(√n)           |
| Space        | O(1)            |

*/
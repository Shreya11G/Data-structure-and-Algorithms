public class floydsCycle {
     static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            // Slow moves one step
            slow = slow.next;

            // Fast moves two steps
            fast = fast.next.next;

            // Both pointers meet
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached null → no cycle
        return false;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create cycle: 5 → 3
        head.next.next.next.next.next = head.next.next;

        System.out.println(hasCycle(head));
    }
}

/*
| Case | Time | Space |
|---|---:|---:|
| Best | `O(1)` | `O(1)` |
| Average | `O(n)` | `O(1)` |
| Worst | `O(n)` | `O(1)` |

Floyd's Cycle Detection uses two pointers, slow and fast, where slow moves one step and fast moves two steps. If a cycle exists, they will eventually meet.
*/
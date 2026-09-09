/**
 * InterpolationSearch
 */
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target){
        int low= 0;
        int high =arr.length-1;
        while(low<high && target>arr[low] && target<arr[high]){
            if(arr[low]==arr[high]){
                if(arr[low]==target) return low;
                return -1;
            }
            int pos = low+ (((target-arr[low])*(high-low))/(arr[high]-arr[low]));
            if(arr[pos]==target) return pos;
            else if(arr[pos]<target){
                low=pos+1;
            }else{
                high=pos-1;
            }
        }
        return -1;
    }

      public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        int target = 70;

        int result = interpolationSearch(arr, target);
        if(result==-1) System.out.println("Not Found");
        else
        System.out.println("Element found at index: " + result);
    }
}

/*
Interpolation Search is an improved searching algorithm for a sorted and uniformly distributed array that estimates the target's position instead of always checking the middle.
| Case             | Time Complexity |
| ---------------- | --------------- |
| Best Case        | `O(1)`          |
| Average Case     | `O(log log n)`  |
| Worst Case       | `O(n)`          |
| Space Complexity | `O(1)`          |

When should you use it?

Interpolation Search works well when:

Array is sorted
Values are uniformly distributed

For example:

10, 20, 30, 40, 50, 60, 70...
*/
/**
 * BinarySearch
 */
public class BinarySearch {

    public static void main(String[] args){
        int[] arr ={ 1,12,23,34,35};
        int target=34;
        int result = binarySearch(arr, target);
        if(result==-1) System.out.println("Not found");
        else
        System.out.println("Element found at index: " + result);
    }
    public static int binarySearch(int[] arr , int target){
        int low = 0;
        int high= arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}

/*
Binary Search efficiently finds an element in a sorted array by repeatedly dividing the search space into half.
| Complexity        | Value      |
| ----------------- | ---------- |
| Best Case         | `O(1)`     |
| Average Case      | `O(log n)` |
| Worst Case        | `O(log n)` |
| Space (Iterative) | `O(1)`     |

*/
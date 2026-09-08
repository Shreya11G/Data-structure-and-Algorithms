/**
 * ExponentialSearch
 */
public class ExponentialSearch {

    public static void main(String[] args){
        int arr[]= {2,3,4,5,6,20,40,50,60,70,80,90};
        int target= 40;
        int result= exponentialSearch(arr, target);
        if(result ==-1) System.out.println("Not Found");
        else System.out.println("Found At index: "+ result);
    }
    public static int exponentialSearch(int[] arr , int target){
        if(arr.length==0) return 0;
        if(arr[0]==target) return 0;
        int i = 1;
        while(i<arr.length && arr[i]<= target){
            i*=2;
        }
        return binarySearch(arr, i/2, Math.min(i, arr.length-1), target);
    }
    public static int binarySearch(int arr[], int low, int high , int target ){
        while(low<= high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target) return mid;
            else if( arr[mid]< target) low= mid+1;
            else high= mid-1;
        }
        return -1;
    }
}

/*
Exponential Search finds the range where the target may exist by exponentially increasing the index (1, 2, 4, 8, ...), then applies Binary Search within that range.
When is it useful?

It is especially useful for:

Unbounded/infinite sorted arrays
When the target is expected to be near the beginning of a large sorted array

| Case             | Time Complexity |
| ---------------- | --------------- |
| Best Case        | `O(1)`          |
| Average Case     | `O(log i)`      |
| Worst Case       | `O(log n)`      |
| Space Complexity | `O(1)`          |

*/
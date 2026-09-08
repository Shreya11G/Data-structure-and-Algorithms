/**
 * Linear_Search
 */
public class Linear_Search {

    public static void main(String[] args ){
        int[] arr= {2,4,6,7,9,10};
        int target= 9;
        int result = linearSearch(arr, target);
        if(result ==-1) System.out.println("NotFound");
        else System.out.println("Found at index: "+ result);
    }
    public static int linearSearch(int arr[], int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
}
/*
Linear Search checks each element sequentially until the target element is found or the array ends.
| Case             | Time Complexity |
| ---------------- | --------------- |
| Best Case        | `O(1)`          |
| Average Case     | `O(n)`          |
| Worst Case       | `O(n)`          |
| Space Complexity | `O(1)`          |

*/
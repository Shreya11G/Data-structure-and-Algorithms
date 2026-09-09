/**
 * TernarySearch
 */
public class TernarySearch {

    public static void main(String[] args){
        int arr[]= {2,3,6,7,8,10};
        int target= 8;
        int result= ternarySearch(arr,target);
        if(result ==-1)System.out.println("Not Found");
        else System.out.println("Element found at index: "+result);
    }
    public static int ternarySearch(int arr[], int target){
        int low =0;
        int high =arr.length-1;
        while(low<=high){
            int mid1= low+(high-low)/3;
            int mid2= low+(high-low)/3;
            if(arr[mid1]==target) return mid1;
            if(arr[mid2]==target) return mid2;
            
            //target is in left part
            if(target<arr[mid1]){
                high=mid1-1;
            }
            //target is in right part
            else if(target> arr[mid2]){
                low=mid2+1;
            }
            //target is in middle part
            else{
                low=mid1+1;
                high=mid2-1;
            }
        }
        return -1;
    }
}
/*
Ternary Search is a searching algorithm used on a sorted array. It divides the search space into 3 parts using two middle points, then continues searching in the part where the target can exist.

| Case         | Time Complexity |
| ------------ | --------------- |
| Best Case    | `O(1)`          |
| Average Case | `O(log₃ n)`     |
| Worst Case   | `O(log₃ n)`     |
| Space        | `O(1)`          |

*/
import java.util.*;
public class InsertionSort {
    public static void main(String args[]){
        int[] arr= {2,7,5,3,6,8,9,2,0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertionSort(int[] arr){
        int n= arr.length;
         for(int i=1;i<n;i++){
            int j = i-1;
            int key =arr[i];
            while(j>=0 && arr[j]> key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;

         }
    }
}
/*
Insertion Sort builds the sorted array one element at a time by inserting each element into its correct position among the previously sorted elements.
| Case                   | Time Complexity |
| ---------------------- | --------------- |
| Best (already sorted)  | `O(n)`          |
| Average                | `O(n²)`         |
| Worst (reverse sorted) | `O(n²)`         |
| Space                  | `O(1)`          |

*/
import java.util.*;

public class SelectionSort {
    public static void main(String args[]){
        int arr[]= {56,34,23,67,78};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        int n= arr.length;
        for(int i=0;i<n;i++){
            //assume current index has minimum element
            int minidx=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minidx]){
                    minidx=j;
                }
            }
            int temp = arr[minidx];
            arr[minidx]=arr[i];
            arr[i]= temp;
        }
    }
}

/*
Selection Sort repeatedly finds the minimum element from the unsorted part and places it at the beginning.

| Case    | Time Complexity |
| ------- | --------------- |
| Best    | `O(n²)`         |
| Average | `O(n²)`         |
| Worst   | `O(n²)`         |
| Space   | `O(1)`          |

Selection Sort = Find minimum → Swap → Move to next position.
*/
/**
 * QuickSort
 */
import java.util.*;
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high){
        if(low>=high) return;
        int pivot= partition(arr, low, high);
        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
    }
    public static int partition(int[] arr, int low, int high){
        int pivot= arr[high];
        int i=low-1;
        for(int j=low; j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
        }
        int temp =arr[i+1];
        arr[i+1]= pivot;
        arr[high]=temp;
        return i+1;
    }
    public static void main(String[] args){
        int[] arr= {34,23,6,67,87,34,56,67};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
}

/*
Quick Sort is a Divide and Conquer algorithm that selects a pivot, places it in its correct position using partitioning, and recursively sorts the left and right parts.

| Case    | TC           |
| ------- | ------------ |
| Best    | `O(n log n)` |
| Average | `O(n log n)` |
| Worst   | `O(n²)`      |

Why worst case O(n²)?

If the pivot always creates an unbalanced partition:

[n-1 elements] | pivot

For example, choosing the last element as pivot on an already sorted array

Average: O(log n) — recursion stack
Worst: O(n) — recursion stack
*/
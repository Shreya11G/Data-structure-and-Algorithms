import java.util.*;
public class BubbleSort {
    public static void main(String[] args){
        int arr[]= {65, 87, 34, 23, 89};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubblesort(int[] arr){
        int n =arr.length;
        for(int i =0;i<n-1;i++){
            boolean swap=false;
            for(int j =0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }

    }
}

// Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order, causing larger elements to "bubble" toward the end.

/*
| Case                                  | Time Complexity |
| ------------------------------------- | --------------- |
| Best case (already sorted, optimized) | `O(n)`          |
| Average case                          | `O(n²)`         |
| Worst case                            | `O(n²)`         |
| Space                                 | `O(1)`          |

After every outer loop iteration, the largest unsorted element reaches its correct position at the end.
*/
import java.util.*;
public class HeapSort {
    public static void main(String[] args){
        int[] arr = {12,45,78,34,22};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapify(int[] arr, int n , int i){
        int largest = i;
        int left = i*2+1;
        int right= i*2+2;
        if(left<n && arr[largest]< arr[left]){
            largest=left;
        }
        if(right<n && arr[largest]< arr[right]){
            largest=right;
        }
        if(largest!=i){
            int temp= arr[i];
            arr[i]= arr[ largest];
            arr[largest]= temp;
            heapify(arr, n, largest);
        }
    }
    public static void heapSort(int[] arr){
        int n = arr.length;
        //step 1: build max heap
        for(int i=n/2;i>=0;i-- ){
            heapify(arr, n, i);
        }
        // step 2: extract element from the heap
        for(int i=n-1;i>=0;i--){
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]= temp;
            heapify(arr, i, 0);
        }
    }
}
/*
Heap Sort uses a Max Heap to repeatedly place the largest element at the end of the array
| Case    | Time         |
| ------- | ------------ |
| Best    | `O(n log n)` |
| Average | `O(n log n)` |
| Worst   | `O(n log n)` |
| Space   | `O(1)`       |

🧠 Remember:

Heap Sort = Build Max Heap → Take maximum → Put at end → Heapify again.
*/
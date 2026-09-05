import java.util.*;
/**
 * ShellSort
 */
public class ShellSort {
    public static void shellSort(int[] arr){
        int n =arr.length;
        //start with a large gap and reduce it
        for(int gap=n/2;gap>0; gap/=2){
            //perform gapped insertion sort
            for(int i=gap;i<n;i++){
                int temp = arr[i];
                int j =i;
                //shift elements by gap
                while(j>=gap && arr[j- gap]>temp){
                    arr[j]=arr[j-gap];
                    j-=gap;
                }
                //place temp at correct position
                arr[j]=temp;
            }
        }
    }
    public static void main(String[] args){
        int arr[]= {23,56,34,23,12,56,78};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/*
Shell Sort is an improved version of Insertion Sort that compares and sorts elements separated by a gap, gradually reducing the gap until it becomes 1.
| Case    | Time Complexity            |
| ------- | -------------------------- |
| Best    | approximately `O(n log n)` |
| Average | approximately `O(n²)`      |
| Worst   | `O(n²)`                    |
| Space   | `O(1)`                     |

*/
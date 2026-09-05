import java.util.*;
/**
 * RadixSort
 */
public class RadixSort {

    public static void radixSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        for(int exp=1;max/exp>0 ; exp*=10){
            countingSort(arr,exp);
        }
    } 
    public static void countingSort(int[] arr, int exp){
        int n = arr.length;
        int[] output=new int[n];
        int[]  count= new int[10];
        //count frequency of digit
        for(int num: arr){
            int digit=(num/exp)%10;
            count[digit]++;
        }
        //prefix sum
        for(int i=1;i<10;i++){
            count[i]=count[i-1]+count[i];
        }
        //build output array (right to left for stability)
        for(int i=n-1;i>=0;i--){
            int digit= (arr[i]/exp)%10;
            output[count[digit]-1]=arr[i];
            count[digit]--;
        }
        // copy back
        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }

    }
    public static void main(String[] args){
        int arr[] = {234, 463, 764, 789, 234,1,4,6};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/*
Radix Sort sorts numbers digit by digit, starting from the least significant digit (LSD), using a stable sorting algorithm such as Counting Sort.
Time Complexity

Let:

n = number of elements
d = number of digits in the maximum number
k = range of digits (10 for decimal numbers)

Each Counting Sort takes:

O(n + k)

And we perform it for d digits:

Time Complexity = O(d × (n + k))

Since k = 10 is constant:

Time Complexity = O(d × n)

If the number of digits d is small/constant:

Approximately O(n)

Space Complexity = O(n + k) → O(n)
*/
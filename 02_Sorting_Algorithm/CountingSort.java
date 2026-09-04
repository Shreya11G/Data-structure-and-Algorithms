import java.util.*;
public class CountingSort{
    public static void main(String[] args){
        int n = 8;
        int arr[]= {4,6,2,3,5,7,3,2};
        int ans[]= countingSort(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] countingSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count=new int[max+1];
        for(int num: arr){
            count[num]++;
        }
        for(int i=1;i<max+1;i++){
            count[i]=count[i-1]+count[i];
        }
        int outarray[] = new int[arr.length];
        
        for(int num : arr){
            int idx = count[num]--;
            outarray[idx-1]=num;
        }
        return outarray;
    }
}

/*
Working of Counting Sort
Find the maximum element in the input array.
Initialize a countArray of size max + 1 with all zeros.
Store the frequency of each element from the input array at its corresponding index in countArray.
Example: if 2 appears twice, countArray[2] = 2.
Convert countArray into prefix sum each index now shows the final position of that element in the sorted order.
Build the output array by iterating the input array from the end (to maintain stability).
Copy output back to the input array.

Time Complexity = O(n + k)
Space Complexity = O(n + k)


*/
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

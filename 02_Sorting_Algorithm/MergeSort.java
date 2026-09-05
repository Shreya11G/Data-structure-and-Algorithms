import java.util.*;
public class MergeSort{
    public static void mergeSort(int[] arr, int low, int high){
        if(low>=high) return;
        int mid =low+(high-low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid , high);
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int temp[]= new int[high-low+1];
        int left =low;
        int right =mid+1;
        int index=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[index++]=arr[left++];
            }else{
                temp[index++]=arr[right++];
            }
        }
        while(left<=mid){
            temp[index++]=arr[left++];
        }
        while(right<=high){
            temp[index++]=arr[right++];
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp[i-low];
        }
    }
    public static void main(String[] args){
        int arr[]={2,4,7,9,2,1,45,6,};
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
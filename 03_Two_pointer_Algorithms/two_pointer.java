public class two_pointer{
    public static boolean twoSum(int arr[] , int target){
        int left =0;
        int right=arr.length-1;
        while(left<right){
            int sum =arr[left]+arr[right];
            if(sum==target) return true;
            else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    public static void main(String args[]){
          int[] arr = {1, 2, 3, 4, 6, 8, 9};

        int target = 9;

        System.out.println(twoSum(arr, target));
    }
}

/*

| Case | Complexity |
|---|---|
| Time | O(n) |
| Space | O(1) |
Two Pointer = Two indices + intelligently move one/both pointers to avoid unnecessary comparisons.
*/
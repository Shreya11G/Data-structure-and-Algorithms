import java.util.*;
public class BucketSort{
    public static void bucketSort(float[] arr){
        int n =arr.length;
        if(n==0) return;
        // create buckets
        List<List<Float>> buckets= new ArrayList<>();
        for(int i =0;i<n;i++){
            buckets.add(new ArrayList<>());
        }
        //put each element into bucket
        for(float num:arr){
            int index= (int)(num*n);
            buckets.get(index).add(num);
        }
        //sort each bucket
        for(List<Float> bucket: buckets){
            Collections.sort(bucket);
        }
        int idx=0;
        //combine all buckets 
        for(List<Float> list: buckets){
            for(float num: list){
                arr[idx++]=num;
            }
        }

    }
    public static void main(String[] args){
         float[] arr = {
            0.42f, 0.32f, 0.33f,
            0.52f, 0.37f, 0.47f,
            0.51f
        };
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/*
Bucket Sort distributes elements into different buckets, sorts each bucket individually, and then combines all buckets.

This implementation works well for numbers in the range [0, 1).

| Case           | Time Complexity          |
| -------------- | ------------------------ |
| Best / Average | `O(n + k)` approximately |
| Worst          | `O(nlogn)`                  |
| Space          | `O(n + k)`               |

*/
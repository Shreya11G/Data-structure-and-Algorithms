public class gapSortMathod{
    public static int nextGap(int gap){
        if(gap<=1) return 0;
        return (gap/2)+(gap%2);
    }
    public static void merge(int[] arr1, int[] arr2){
        int n =arr1.length;
        int m = arr2.length;
        int gap = nextGap(n+m);
        while(gap>0){
            int i=0;
            int j=gap;
            while(j<n+m){
                int a , b;
                if(i<n){
                    a=arr1[i];
                }else{
                    a=arr2[i-n];
                }
                if(j<n){
                    b=arr1[j];
                }else{
                    b=arr2[j-n];
                }
                if(a>b){
                    if(i<n && j<n){
                        int temp= arr1[i];
                        arr1[i]=arr1[j];
                        arr1[j]=temp;
                    }else if(i<n && j>=n){
                        int temp= arr1[i];
                        arr1[i]=arr2[j-n];
                        arr2[j-n]= temp;
                    }else{
                        int temp =arr2[i-n];
                        arr2[i-n]=arr2[j-n];
                        arr2[j-n]=temp;
                    }
                }
                j++;
                i++;
            }
            gap =nextGap(gap);
        }
    }
    public static void main(String[] args) {
        int[] arr1= {23,45,12,3,23};
        int[] arr2= {45,67,34,23};
        merge(arr1, arr2);
        for(int x: arr1){
            System.out.print(x+ " ");
        }
        for(int x: arr2){
            System.out.print(x+ " ");
        }
    }
}
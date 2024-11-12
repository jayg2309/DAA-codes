package java_pr;

public class QuickSort {
    public static int partition(int[] arr,int low,int high){
        int pivot = arr[high];//set pivot to last
        int i = low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //now put pivot at end using swapping
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void Quicksort(int[] arr, int low, int high){
        if( low<high){
            int pidx = partition(arr,low,high); // pidx = pivot index
            Quicksort(arr,low,pidx-1);
            Quicksort(arr,pidx+1,high);
        }
    }
    public static void main(String[] args){
        int[] arr = {6,3,9,5,2,8};
        int n= arr.length;

        Quicksort(arr,0,n-1);
        //print array
        for(int j=0;j<n;j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}

// tc - O(log n) 
// worst case - O(n^2)
// sc - O(log n)
package java_pr;

public class binarysearchrec {

    public static void bin_search_rec(int a[],int low,int high,int val){
        int mid = (low+high)/2;
        if(low>high){
            System.out.println("value not found");
            return;
        }

        if (a[mid]==val){
            System.out.println(mid);
            
        } 
        if(val<a[mid]){
            bin_search_rec(a,low,mid-1,val);
        }
        if(val>a[mid]){
            bin_search_rec(a,mid+1, high, val);
        }


    }    
    public static void main(String[] args){
        int a[] = {1,23,34,56,77,89,93};
        int low = 0;
        int high =  a.length;
        int val = 79;
        
        bin_search_rec(a, low, high, val);
        
    }
}

// tc - O(log n)
// sc - O(log n)
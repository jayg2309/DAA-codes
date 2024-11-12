package java_pr;

public class linearsearch {
    public static void main(String[] args){
        int a[] = {3,45,61,12,23};
        int search = 22;
        boolean found = false;
        for(int i=0;i<a.length;i++){
            if (a[i]==search){
                System.out.println("Value found at "+i);
                found = true;
            }
        }
        if (found == false){
            System.out.println("Value not found");
        }
    }
}
// tc - O(n)
// sc - O(1)
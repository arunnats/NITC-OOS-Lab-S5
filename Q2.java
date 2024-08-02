import java.util.*;

class Q2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in the array");
        int n = sc.nextInt();

        System.out.println("Enter elements of the array");
        Vector<Integer> arr = new Vector<>();
        for(int i = 0; i < n; i++){
            arr.addElement(sc.nextInt());
        }

        System.out.println("Enter element to be searched");
        int k = sc.nextInt();
        
        int l = 0, r = n-1;

        while(l <= r)
        {
            int mid = l + (r-l)/2;

            if(arr.get(mid) == k){
                System.out.println("Element found at position "+mid);
                return;
            }
            else if(arr.get(mid) < k){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println("Element not found");
        return;
    }
} 
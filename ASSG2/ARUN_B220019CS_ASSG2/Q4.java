public class Q4{
    public static void main(String args[]){
        int[] arr = {1,363,3,532,5,6};
        Solution S = new Solution();
        int ans = S.util(arr, 0);
        System.out.println(ans);
    }
}

class Solution{
    int maxElem;

    Solution(){
        maxElem = Integer.MIN_VALUE;
    }

    int util(int[] arr, int idx){
        if(idx >= arr.length){
            return maxElem;
        }
        maxElem = Math.max(maxElem, arr[idx]);
        util(arr, idx+1);
        return maxElem;
    }    
}
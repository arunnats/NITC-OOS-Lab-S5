public class Q5{
    public static void main(String args[]){
        String input = "OOS lab or something";
        Solution S = new Solution();
        System.out.println(S.util(input));
    }
}

class Solution{
    String util(String str){
        char[] charArr = str.toCharArray();

        recurse(charArr, 0, charArr.length-1);
        
        String ans = new String(charArr);
        return ans;
    }    

    void swap (char[] charArr, int i, int j) {
        char t = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = t;
    }

    void recurse(char[] charArr, int l, int r){
        if(l > r)
            return;
        
        swap(charArr, l, r);
        recurse(charArr, l+1, r-1);

        return;
    }
}
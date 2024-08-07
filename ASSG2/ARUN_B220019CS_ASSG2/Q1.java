public class Q1 {
    public static void main(String[] args) {
        String str = "hello world";
        String substr = "world";
        Solution S = new Solution();
        System.out.println(S.util(str, substr)); 
    }
}

class Solution {
    boolean util(String str, String substr) {
        int n = str.length();
        int m = substr.length();
        for (int i = 0; i <= n - m; i++) {
            if (substr.equals(str.substring(i, i + m))) {
                return true;
            }
        }
        return false;
    }
}

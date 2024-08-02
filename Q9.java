import java.util.*;

class CharFreq{
    public static void main(String args[]){
        int[] chars = new int[26];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String");
        String str = sc.nextLine();
        str.toLowerCase();
        char[] temparray = str.toCharArray();

        for (char c : temparray)
            chars[c - 'a']++;

        for(int i = 0; i < 26; i++){
            if(chars[i] > 0){
                String s = Character.toString((char)'a' + i);
                System.out.println("Freq of " + s + " = " + chars[i]);
            }
        }
    }
}
import java.lang.*;
import java.io.*;
import java.util.*;

class ReverseString{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String");
        String str = sc.nextLine();
        
        char[] temparray = str.toCharArray();
        int r = temparray.length - 1;
        int l = 0;

        while(l <= r) {
            char temp = temparray[l];
            temparray[l] = temparray[r];
            temparray[r] = temp;
            l++;
            r--;
        }

        for (char c : temparray)
            System.out.print(c);
        System.out.println();
    }
}
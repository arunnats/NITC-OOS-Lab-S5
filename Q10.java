import java.lang.*;
import java.io.*;
import java.util.*;

class SwapStrings{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String 1");
        String str1 = sc.nextLine();

        System.out.println("Enter String 2");
        String str2 = sc.nextLine();

        System.out.println("Strings before swapping: " + str1 + " " + str2);    

        str1 = str1 + str2;    

        str2 = str1.substring(0, (str1.length() - str2.length()));    
        str1 = str1.substring(str2.length());   

        System.out.println("Strings after swapping: " + str1 + " " + str2);     
    }
}
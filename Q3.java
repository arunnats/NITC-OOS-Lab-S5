import java.util.*;
class FindVowel{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String");
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                System.out.println("Vowel found");
                return;
            }
        } 
        
        System.out.println("Vowel not found");
        return;
    }
}
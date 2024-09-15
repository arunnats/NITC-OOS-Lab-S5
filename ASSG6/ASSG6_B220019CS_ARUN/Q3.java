public class Q3 {
    public static void main(String[] args) {
        Student S = new Student();
        NITCalicutStudent K = new NITCalicutStudent();

        S.formatName("Arun ComputerScience CS123");
        K.formatName("Kamble ComputerSciencfe CS25165251");
    }
}

class Student {
    protected String reverseString (String str) {
        StringBuffer sbr = new StringBuffer(str);
        sbr.reverse();
        return sbr.toString();
    }

    protected int vowelCount (String str) {
        int count = 0;
        for (int i = 0 ; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'|| ch == 'A'|| ch == 'E'|| ch == 'I'|| ch == 'O'|| ch == 'U') {
                count ++;
            }
         }
         return count;
    }

    protected Boolean palindrome (String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public void formatName(String str) {
        String[] stringSplit = str.split(" ");
        System.out.println("Reversed Name: " + this.reverseString(stringSplit[0]));
        System.out.println("Vowel Count: " + this.vowelCount(stringSplit[1]));
        System.out.println("Palindrome Check: " + this.palindrome(stringSplit[2]));
    }
}

class NITCalicutStudent extends Student{
    @Override
    protected String reverseString (String str) {
        StringBuffer sbr = new StringBuffer(str);
        sbr.reverse();
        sbr.append("(NIT Calicut)");
        return sbr.toString();
    }

    public void formatName(String str) {
        String[] stringSplit = str.split(" ");
        System.out.println("Reversed Name: " + this.reverseString(stringSplit[0]));
        System.out.println("Vowel Count: " + this.vowelCount(stringSplit[1]));
        System.out.println("Palindrome Check: " + this.palindrome(stringSplit[2]));
    }
}

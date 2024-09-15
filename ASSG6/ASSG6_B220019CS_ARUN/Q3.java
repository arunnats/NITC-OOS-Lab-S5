public class Q3 {
    public static void main(String[] args) {
        Student s1 = new Student("Arun", "Computer Science", "CS123");
        NITCalicutStudent s2 = new NITCalicutStudent("Kamble", "Computer Science", "CS25165251");

        s1.formatName();
        s2.formatName();
    }
}

class Student {
    public String name;
    public String department;
    public String rollNumber;

    public Student(String name, String department, String rollNumber) {
        this.name = name;
        this.department = department;
        this.rollNumber = rollNumber;
    }

    protected String reverseString(String str) {
        StringBuffer sbr = new StringBuffer(str);
        sbr.reverse();
        return sbr.toString();
    }

    protected int vowelCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count++;
            }
        }
        return count;
    }

    protected boolean palindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void formatName() {
        System.out.println("Reversed Name: " + reverseString(this.name));
        System.out.println("Vowel Count: " + vowelCount(this.department));
        System.out.println("Palindrome Check: " + palindrome(this.rollNumber));
        System.out.println("Student Details: " + this.name + " - Department: " + this.department + ", Roll Number: " + this.rollNumber);
    }
}

class NITCalicutStudent extends Student {

    public NITCalicutStudent(String name, String department, String rollNumber) {
        super(name, department, rollNumber);
    }

    @Override
    protected String reverseString(String str) {
        StringBuffer sbr = new StringBuffer(str);
        sbr.reverse();
        sbr.append(" (NIT Calicut)");
        return sbr.toString();
    }

    @Override
    public void formatName() {
        System.out.println("Reversed Name with Tag: " + reverseString(this.name));
        System.out.println("Vowel Count: " + vowelCount(this.department));
        System.out.println("Palindrome Check: " + palindrome(this.rollNumber));
        System.out.println("Student Details: " + this.name + " - Department: " + this.department + ", Roll Number: " + this.rollNumber);
    }
}
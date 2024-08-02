import java.util.Scanner;
class Factorial{
    public static void main(String args[]){
        int fact = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n to find n!");
        int count = sc.nextInt();

        for(int i = 1; i <= count; i++){
            fact = fact * i;
       }

        System.out.println(fact);
    }
}
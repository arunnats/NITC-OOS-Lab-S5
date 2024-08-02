 import java.util.Scanner;  
 public class MenuDrivenCalculator {  
        public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        int choice;  

        do {  
            System.out.println("1. Addition");  
            System.out.println("2. Subtraction");  
            System.out.println("3. Multiplication");  
            System.out.println("4. Division");  
            System.out.println("5. Exit");  
            System.out.print("Enter your choice: ");  

            choice = input.nextInt();  

            switch (choice) {  
                case 1:  
                    performAddition();  
                    break;  

                case 2: 
                    performSubtraction();  
                    break;  

                case 3:  
                    performMultiplication();  
                    break;  

                case 4:  
                    performDivision();  
                    break;  

                case 5:  
                    break;  

                default:  
                    System.out.println("Invalid choice. Please try again.");  
            }  
        } while (choice != 5);  
        input.close();  
    }  


    private static void performAddition() {  

        Scanner input = new Scanner(System.in);  
        System.out.print("Enter the first number: ");  
        double num1 = input.nextDouble();  
        System.out.print("Enter the second number: ");  
        double num2 = input.nextDouble();  

        double result = num1 + num2;  
        System.out.println("Result: " + result);  
    }  

    private static void performSubtraction() {  
        Scanner input = new Scanner(System.in);  
        System.out.print("Enter the first number: ");  
        double num1 = input.nextDouble();  
        System.out.print("Enter the second number: "); 
        double num2 = input.nextDouble();  

        double result = num1 - num2;  
        System.out.println("Result: " + result);  
    }  

    private static void performMultiplication() {  
        Scanner input = new Scanner(System.in);  
        System.out.print("Enter the first number: ");  
        double num1 = input.nextDouble();  
        System.out.print("Enter the second number: ");  
        double num2 = input.nextDouble();  

        double result = num1 * num2;  
        System.out.println("Result: " + result);  

    } 

    private static void performDivision() { 
        Scanner input = new Scanner(System.in);  
        System.out.print("Enter the dividend: ");  
        double dividend = input.nextDouble();  
        System.out.print("Enter the divisor: ");  
        double divisor = input.nextDouble();  

        if (divisor != 0) {  
            double result = dividend / divisor;  
            System.out.println("Result: " + result);  
        } else {  
            System.out.println("Error: Division by zero is not allowed.");  
        }  
    }  
 } 
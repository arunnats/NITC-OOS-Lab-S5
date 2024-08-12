import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator(); // calc is short for calculator btw chat
        try {
            String operator = sc.nextLine();
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());

            int result = calc.calculate(operator, a, b);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Invalid input. Enter digits only.");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mult(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero handled. Enter a valid argument.");
        }
        return a / b;
    }

    public int calculate(String operator, int a, int b) throws ArithmeticException {
        switch (operator) {
            case "+":
                return add(a, b);
            case "-":
                return sub(a, b);
            case "*":
                return mult(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}

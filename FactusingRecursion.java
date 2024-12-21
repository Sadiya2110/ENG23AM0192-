
import java.util.Scanner;
public class FactusingRecursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input number for factorial
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Calculate factorial using recursion
        long factorial = factorial(number);
        
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
    
    // Recursive method to calculate factorial
    public static long factorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
    


package Basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOutputScanner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            printNumber(sc);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
    public static void printNumber(Scanner sc) {
        System.out.print("Enter a number: ");
        int number = sc.nextInt(); // Read an integer from user
        System.out.println("You entered: " + number);
    }
}

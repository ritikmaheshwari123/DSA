package Basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IfElseIf {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            studentGrade(sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    public static void studentGrade(int marks){
        if (marks >= 90 ){
            System.out.println("Grade A");
        } else if (marks >= 70){
            System.out.println("Grade B");
        } else if (marks >= 50){
            System.out.println("Grade C");
        } else if (marks >= 35){
            System.out.println("Grade D");
        } else {
            System.out.println("Fail");
        }
    }
}

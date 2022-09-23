package lec;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        //using Scanner
        Scanner myObj = new Scanner(System.in);
        //clear standard input
        //myObj.nextLine();
        // start new input
        System.out.print("Enter your name: ");
        //string input
        String name = myObj.nextLine();
        // numerical input
        System.out.print("Enter age: ");
        int age = myObj.nextInt();
        System.out.print("Enter salary: ");
        double salary = myObj.nextDouble();

        // output to standard output
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Income: " + salary);
    }
}

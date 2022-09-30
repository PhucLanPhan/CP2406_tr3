package prac.week_02;

import textio.TextIO;

public class Greet {
    public static void main(String[] args) {

            String usersName;
            String upperCaseName;

            System.out.print("Please enter your name: ");
            usersName = TextIO.getln();

            upperCaseName = usersName.toUpperCase();

            System.out.println("Hello, " + upperCaseName + ", nice to meet you!");

    }
}

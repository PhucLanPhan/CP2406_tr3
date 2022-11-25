package practical;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex82 {
    private static final BigInteger THREE = new BigInteger("3");
    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger TWO = new BigInteger("2");


    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );

        String line;

        BigInteger N;

        System.out.println("This program will print 3N+1 sequences for positive starting values");
        System.out.println("that you enter.  There is no pre-set limit on the number of");
        System.out.println("digits in the numbers that you enter.  The program will end when");
        System.out.println("you enter an empty line.");

        while (true) {
            System.out.println();
            System.out.println("Enter the starting value, or press return to end.");
            System.out.print("? ");
            line = scanner.nextLine().trim();
            if (line.length() == 0)
                break;
            try {
                N = new BigInteger(line);
                if (N.signum() == 1)
                    printThreeNSequence(N);
                else
                    System.out.println("Error:  The starting value cannot be less than or equal to zero.");
            }
            catch (NumberFormatException e) {
                System.out.println("Error:  \"" + line + "\" is not a legal integer.");
            }
        }

        System.out.println();
        System.out.println("OK.  Bye for now!");

    }
    private static void printThreeNSequence(BigInteger N) {

        assert N != null && N.signum() == 1 : "Illegal parameter value.";

        int count;

        System.out.println();
        System.out.println("The 3N+1 sequence starting with " + N + " is:");
        System.out.println();

        System.out.println(N.toString());
        count = 1;

        while ( ! N.equals(ONE) ){
            if (N.testBit(0) == false) {
                N = N.divide(TWO);
            }
            else {
                N = N.multiply(THREE);
                N = N.add(ONE);
            }
            System.out.println(N.toString());
            count++;
        }

        System.out.println();
        System.out.println("There were " + count + " terms in the sequence.");

    }


}

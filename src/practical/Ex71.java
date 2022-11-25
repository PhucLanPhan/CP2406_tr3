package practical;

import java.util.ArrayList;

public class Ex71 {
    public static ArrayList<Integer> makeRandomInts( int count, int max ) throws IllegalArgumentException {
        if (count > max) {
            throw new IllegalArgumentException("Can't have " + count +
                    " different integers in the range  1 to " + max);
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (numbers.size() < count) {
            int num = (int)(Math.random()*max) + 1;
            if ( numbers.indexOf(num) == -1 )
                numbers.add( num );
        }
        return numbers;
    }

    public static void main(String[] args) {
        System.out.println("10 integers chosen from the range 1 to 100:");
        for (int i = 0; i < 8; i++)
            System.out.println( makeRandomInts(10,100) );
        System.out.println();
        System.out.println("10 integers chosen from the range 1 to 10:");
        for (int i = 0; i < 3; i++)
            System.out.println( makeRandomInts(10,10) );
        System.out.println();
        System.out.println("25 integers chosen from the range 1 to 10000:");
        System.out.println( makeRandomInts(25,10000) );
        System.out.println();
        System.out.println("End with an exception!");
        ArrayList<Integer> integers = makeRandomInts(10, 9);
    }

}

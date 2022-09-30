package prac.week_02;

public class Dice {
    public static void main(String[] args) {

        int roll_1;
        int roll_2;
        int total_roll;

        roll_1 = (int)(Math.random()*6) + 1;
        roll_2 = (int)(Math.random()*6) + 1;
        total_roll = roll_1 + roll_2;

        System.out.println("The first die comes up " + roll_1);
        System.out.println("The second die comes up " + roll_2);
        System.out.println("Your total total_roll is " + total_roll);
    }
}
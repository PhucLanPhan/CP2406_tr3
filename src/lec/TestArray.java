package lec;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] myNumber = {1,2,3,4,5};
        for (int i = 0; i < 5; i++){
            System.out.print(myNumber[i] + " ");
        }
        int j = 0;
        while (j < 5){
            System.out.print(myNumber[j] + " ");
            j++;
        }

        //array of 3 strings
        String[] names = new String[3];
        names[0] = "Rutchi";
        names[1] = "Praise";
        names[2] = "Tiri";
        System.out.println(Arrays.toString(names));
        for (String name : names) {
            System.out.println(name);
        }

        //array of 3 students
        Person[] group = {new Person("Rutchi","123 abc street", 20),
                        new Person("praise", "456 abc street", 18),
                        new Person("Harry", "90 OMG street", 28)};
        for(Person person:group){
            System.out.println(person);
        }

        String[] myGroup = new String[] {"Praise", "Rutchi", "Tiri"};
        myGroup = Arrays.copyOf(myGroup, 5);
        myGroup[3] = "Park";
        myGroup[4] = "Phuc";
        System.out.println(Arrays.toString(myGroup));

        ArrayList<Person> group1 = new ArrayList<>();
        group1.add(new Person("Rutchi","123 abc street", 20));
        group1.add(new Person("Harry", "90 OMG street", 28));
        System.out.println("size = " + group1.size());

        for(Person person1: group1){
            System.out.println(person1);
        }

        group1.remove(0);
        System.out.println("size = " + group1.size());

        group1.clear();
        System.out.println("size = " + group1.size());

        for (Person person2: group1){
            System.out.println(person2);
        }
    }

}
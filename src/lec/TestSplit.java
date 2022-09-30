package lec;

public class TestSplit {
    public static void main(String[] args) {
        String s = "I am a student";
        String[] result = s.split(" ", 0);
        // String[] result = s.split(" a", 0);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}

package prac.week_02;

public class draft {
    public static void main(String[] args) {
        char[][] pic = new char[6][6];
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++) {
                if ( i == j  ||  i == 0  ||  i == 5 )
                    pic[i][j] = '*';
                else
                    pic[i][j] = '.';
            }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++)
                System.out.print(pic[i][j]);
            System.out.println();
        }
    }
}
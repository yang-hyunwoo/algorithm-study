package sort.main10817;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] Nary;




    public static void input() {
        Scanner scan = new Scanner(System.in);
        Nary = new int[3];
        for(int i = 0; i <= 2; i++){
            Nary[i] = scan.nextInt();
        }

        Arrays.sort(Nary);

        System.out.println(Nary[1]);
    }


    public static void main(String[] args) {
        input();
    }

}
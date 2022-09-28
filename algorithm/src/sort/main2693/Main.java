package sort.main2693;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N;
    static Integer[] Nary;

    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    public static void input() {
        Nary = new Integer[10];
        for(int i = 0 ; i <= 9; i++) {
            Nary[i] = scan.nextInt();
        }

        Arrays.sort(Nary, Collections.reverseOrder());

        sb.append(Nary[2]).append("\n");

    }


    public static void main(String[] args) {
        N = scan.nextInt();
        for(int i = 1 ; i <=N ; i++){
            input();
        }
        System.out.println(sb.toString());
    }

}
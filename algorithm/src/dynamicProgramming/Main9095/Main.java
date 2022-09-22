package dynamicProgramming.Main9095;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Dy;
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    public static void preprocess() {
        Dy = new int[15];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for(int i = 4 ; i <= 11 ; i++) {
            Dy[i] = Dy[i-3] + Dy[i-2] + Dy[i-1];
        }
    }

    public static void input() {
        M = scan.nextInt();
        System.out.println(Dy[M]);

    }


    public static void main(String[] args) {
        preprocess();
        N = scan.nextInt();
        for(int i = 1; i <= N ; i++) {
            input();
        }
    }

}
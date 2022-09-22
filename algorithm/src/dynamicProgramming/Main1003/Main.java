package dynamicProgramming.Main1003;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Dy;        // 0
    static int[] Dy2;       // 1
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void preprocess() {
        Dy = new int[45];
        Dy2 = new int[45];

        Dy[0] = 1;
        Dy2[0] = 0;

        Dy[1] = 0;
        Dy2[1] = 1;

        Dy[2] = 1;
        Dy2[2] = 1;

        for(int i = 3 ; i <=44; i++){
            Dy[i] = Dy[i-1] + Dy[i-2];
            Dy2[i] = Dy2[i-1] + Dy2[i-2];
        }

    }

    public static void input() {
        sb.setLength(0);
        M = scan.nextInt();
        sb.append(Dy[M]).append(" ").append(Dy2[M]);
        System.out.println(sb.toString());

    }


    public static void main(String[] args) {
        preprocess();
        N = scan.nextInt();
        for(int i = 1 ; i <= N ; i++){
            input();
        }
    }

}
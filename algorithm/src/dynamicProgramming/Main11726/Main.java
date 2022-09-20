package dynamicProgramming.Main11726;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] Dy;

    static StringBuilder sb = new StringBuilder();

    public static void preprocess() {
        Dy = new int[1005];

        Dy[1] = 1;
        Dy[2] = 2;

        for(int i = 3 ; i <=1004; i++) {
            Dy[i] = (Dy[i-1] + Dy[i-2])%10007;
        }

    }

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        System.out.println(Dy[N]);
    }


    public static void main(String[] args) {
        preprocess();
        input();
    }

}
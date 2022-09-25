package dynamicProgramming.main2579;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Dy;
    static int[] Nary;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Dy = new int[305];
        Nary = new int[305];

        for(int i = 1 ; i <= N ; i++) {
            Nary[i] = scan.nextInt();
        }

        dp();
    }

    public static void dp() {

        Dy[1] = Nary[1];
        Dy[2] = Nary[2]+Nary[1];
        Dy[3] = Nary[3] + Math.max(Nary[2], Nary[1]);

        for (int i = 4; i <= N; i++) {
            Dy[i] = Math.max(Dy[i - 3] + Nary[i - 1], Dy[i - 2]) + Nary[i];
          }

        System.out.println(Dy[N]);
        
    }


    public static void main(String[] args) {
        input();
    }

}
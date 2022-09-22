package dynamicProgramming.main2748;

import java.util.Scanner;

public class Main {

    static int N;
    static long[] Dy;


    public static void preprocess(){
        Dy = new long[95];
        Dy[0] = 0;
        Dy[1] = 1;
        Dy[2] = 1;
        Dy[3] = 2;

        for(int i = 4 ; i <= 94; i++) {
            Dy[i] = Dy[i-2] + Dy[i-1];
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
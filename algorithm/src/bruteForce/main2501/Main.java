package bruteForce.main2501;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new int[N+1];
        int count = 1;
        for(int i = 1 ; i <= N ; i++) {
            if(N%i==0) {
                Nary[count] = i;
                count++;
            }
        }

        System.out.println(Nary[M]);

    }


    public static void main(String[] args) {
        input();
    }

}
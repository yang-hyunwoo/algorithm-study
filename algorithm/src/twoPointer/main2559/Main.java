package twoPointer.main2559;

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

        for(int i = 1 ; i <= N ; i++) {
            Nary[i] = scan.nextInt();
        }

        two_pointer();
    }

    public static void two_pointer() {
        int R = 0;
        int sum = 0;
        int max = -100 * N;
        for(int L = 1 ; L <= (N-M+1); L++) {
            sum -=Nary[L-1];
            while(R+1 <= N && R+1<L+M) {
                R++;
                sum +=Nary[R];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        input();

    }

}

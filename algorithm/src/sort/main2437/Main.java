package sort.main2437;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N+1];

        for(int i = 1; i <= N ;i++) {
            Nary[i] = scan.nextInt();
        }

        Arrays.sort(Nary,1,N+1);

        int sum = 0;
        for (int i=1; i<=N; i++) {
            if (sum + 1 < Nary[i]) {
                break;
            }

            sum += Nary[i];
        }

        System.out.println(sum+1);


    }


    public static void main(String[] args) {
        input();
    }

}
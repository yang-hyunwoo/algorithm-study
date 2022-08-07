package twoPointer.main1940;

import java.util.Arrays;
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

        for(int i = 1 ; i <= N ; i++){
            Nary[i] = scan.nextInt();
        }
        two_pointer();
    }

    public static void two_pointer() {
        int cnt = 0;
        for(int start=1; start <= N; start++)  {
            int sum = 0;
            int end = start+1;

            while (end <= N) {
                sum = Nary[start];
                sum += Nary[end++];
                if (sum == M) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) {
        input();
    }

}

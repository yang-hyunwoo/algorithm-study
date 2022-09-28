package binarysearch.main13702;

import java.util.Scanner;
public class Main {
    static int N,M;
    static int[] ary;

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        ary = new int[N+1];
        for(int i = 1; i <=N; i++) {
            ary[i] = scan.nextInt();
        }
    }

    static boolean determination(long data) {
        if(data == 0) {
            return false;
        }
        long sum = 0;
        for(int i = 1; i <= N; i++) {
            sum+= ary[i] / data;
        }
        return sum >= M;
    }

    static void run() {
        long L = 0, R = Integer.MAX_VALUE, ans = 0;
        while(L <= R) {
            long mid = (L+R)/2;
            if(determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }

        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        run();
    }
}
package binarysearch.main1300;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static int N,M;
    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

    }

    static boolean determination(long candidate) {
        long sum= 0;
        for(int i =1; i<=N;i++) {
            sum += Math.min(N,candidate/i);
        }
        return sum >= M;
    }

    static void run() {
        long L = 1, R = (long)N*N , ans =0 ;
        while(L <=R) {
            long mid = (L+R)/2;
            if(determination(mid)) {
                ans = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        run();

    }
}
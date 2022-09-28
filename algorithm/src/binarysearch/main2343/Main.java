package binarysearch.main2343;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static int N,M;
    static int[] ary;
    static int[] ary2;
    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        ary = new int[N+1];
        for(int i = 1; i <= N; i++) {
            ary[i] = scan.nextInt();
        }
    }

    static boolean determination(int len) {
        int cnt = 1 , sum = 0;
        for(int i = 1; i <= N; i++) {
            if(sum+ary[i]>len) {
                cnt++;
                sum = ary[i];
            }else {
                sum += ary[i];
            }
        }
        return cnt <= M;
    }

    static void run() {
        int L = ary[1], R = 1000000000, ans = 0;
        for (int i = 1; i <= N; i++) L = Math.max(L, ary[i]);
        while(L <=R) {
            int mid = (L+R)/2;
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

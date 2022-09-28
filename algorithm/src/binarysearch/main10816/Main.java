package binarysearch.main10816;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static int N , M;
    static int[] ary , ary2;
    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        ary = new int[N+1];
        for(int i = 1; i <= N; i++) {
            ary[i] = scan.nextInt();
        }
        M = scan.nextInt();
        ary2 = new int[M+1];
        for(int i = 1; i <= M; i++) {
            ary2[i] = scan.nextInt();
        }
    }

    static int lower_bound(int[] A , int L , int R , int X) {
        int max =Integer.MIN_VALUE;
        int mid = 0;
        while(L <= R) {
            mid = (L+R)/2;
            if(A[mid]<=X) {
                L = mid + 1;
            }else {
                R = mid - 1;
            }
            if(A[mid]==X) {
                if(max <mid) {
                    max = mid;
                }
            }
        }
        if(max == Integer.MIN_VALUE) {
            max = 0 ;
        }
        return max;
    }

    static int high_bound(int[] A , int L , int R , int X) {
        int mid =0;
        int min = Integer.MAX_VALUE;
        while(L >= R) {
            mid = (L+R)/2;
            if(A[mid]==X) {
                if(min >mid) {
                    min = mid;
                }
            }
            if(A[mid]<X) {
                R = mid+1;
            }else {
                L = mid-1;
            }
        }
        if(min == Integer.MAX_VALUE) {
            min = 0 ;
        }
        return min;
    }

    static void run() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= M ; i++) {
            if(lower_bound(ary,1,N,ary2[i])==0) {
                sb.append(high_bound(ary,N,1,ary2[i])).append(" ");
            }else {
                sb.append((lower_bound(ary,1,N,ary2[i]) - high_bound(ary,N,1,ary2[i]))+1).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(ary,1,N+1);
        run();
    }
}
package binarysearch.main1654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M , max = Integer.MIN_VALUE;
    static int[] Nary;


    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new int[N+1];
        for(int i = 1; i <= N ; i++) {
            Nary[i] = scan.nextInt();
        }
    }

    static void sort() {
        Arrays.sort(Nary , 1 , N+1);
        long L = 1 , R = Integer.MAX_VALUE , ans = 0;
        while(L <=R){
            long mid = (L+R) / 2;
            if(max_length((int)mid)) {
                max = Math.max(max,(int)mid);
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(max);
    }

    static boolean max_length(int H) {
        int tot = 0;
        for(int i = 1 ; i <= N ; i++){
            tot += Nary[i]/H;
        }
        return  tot >=M;
    }

    public static void main(String[] args) {
        input();
        sort();
    }

}
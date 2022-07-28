package binarysearch.main2805;

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
        for(int i = 1 ; i <= N ; i++) {
            Nary[i] = scan.nextInt();
        }
    }

    static boolean determination(int H) {
        long sum = 0;
        for(int i = 1 ; i <= N ; i++){
            if(Nary[i]>H){
                sum += Nary[i]-H;
            }
        }
        return sum >= M;

    }
    static void binary_search() {
        Arrays.sort(Nary , 1 , N+1);
        long L = 0 , R = 2000000000, X = 0;
        while(L <= R) {
            long mid = (L+R)/2;
            if(determination((int)mid)) {
                X= mid;
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        System.out.println(X);

    }
    public static void main(String[] args) {
        input();
        binary_search();
    }

}
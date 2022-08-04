package twoPointer.main2230;

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
        Arrays.sort(Nary, 1 , N+1);
        two_pointer();
    }

    public static void two_pointer() {
        int R =1 , ans = 0 , min = Integer.MAX_VALUE;

        for(int L = 1 ; L <= N ; L++){
            while(R+1 <= N && Nary[R] - Nary[L]<M) {
                R++;
            }
            if(Nary[R]-Nary[L] >=M) {
                    min = Math.min(min , Nary[R]-Nary[L]);
                }

        }
        System.out.println(min);
    }


    public static void main(String[] args) {
        input();
    }

}
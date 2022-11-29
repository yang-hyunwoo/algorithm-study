package sort.main16435;

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
        Nary = new int[N];
        for(int i = 0 ; i < N ; i++) {
            Nary[i] = scan.nextInt();
        }
        sort();
    }

    public static void sort() {
        Arrays.sort(Nary);

        for(int i = 0 ; i < N ; i++) {
            if(M>=Nary[i]) {
                M++;
            }else {
                break;
            }
        }
        System.out.println(M);
    }



    public static void main(String[] args) {
        input();
    }

}
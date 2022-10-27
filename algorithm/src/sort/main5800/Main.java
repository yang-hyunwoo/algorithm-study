package sort.main5800;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    public static void input(int k) {
        M = scan.nextInt();
        Nary = new int[M];

        for(int i = 0 ; i < M ; i++) {
            Nary[i] = scan.nextInt();
        }

        Arrays.sort(Nary);

        int max = 0;
        for(int i = 0 ; i < M-1; i++) {
            int sum = Nary[i+1]-Nary[i];
            max = Math.max(max , sum);
        }
        System.out.println("Class "+k);
        System.out.println("Max "+Nary[M-1]+", Min " + Nary[0]+", "+"Largest gap "+max);



    }


    public static void main(String[] args) {
        N = scan.nextInt();
        for(int i = 1 ; i <= N ; i++){
            input(i);
        }
    }

}
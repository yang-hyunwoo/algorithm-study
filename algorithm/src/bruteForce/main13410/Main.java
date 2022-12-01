package bruteForce.main13410;

import java.util.Scanner;


public class Main {

    static int N,M,max;
    static int[] Mary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Mary = new int[M+1];

        for (int i = 1; i <= M; i++) {
            Mary[i] = N * i;
        }
        bruteForce();
    }

    private static void bruteForce() {

        for(int i = 1 ; i < Mary.length ; i++) {
            String a = "";
            for(int j=String.valueOf(Mary[i]).length(); j >=1;j--) {
                a += String.valueOf(Mary[i]).charAt(j-1);
            }
            max = Math.max(max, Integer.parseInt(a));
        }

        System.out.println(max);
    }


    public static void main(String[] args) {
        input();
    }

}
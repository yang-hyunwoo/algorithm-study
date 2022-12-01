package bruteForce.main10419;

import java.util.Scanner;


public class Main {

    static int T;
    static int[] d;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        d = new int[T];

        for(int i = 0 ; i < T ; i++) {
            d[i] = scan.nextInt();
        }

        bruteForce();
    }

    private static void bruteForce() {
        int max = 0;
        for(int i = 0; i < T ; i++) {
            int t=1;
            while((t*t)+t <= d[i]){
                t++;
            }
            System.out.println(t-1);
        }
    }

    public static void main(String[] args) {
        input();
    }

}
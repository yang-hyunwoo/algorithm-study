package bruteForce.main1476;

import java.util.Scanner;

public class Main {

    static int E,S,M;

    static StringBuilder sb = new StringBuilder();
    static int x=0 , y=0, z=0 ;

    public static void input() {
        Scanner scan = new Scanner(System.in);
        E = scan.nextInt();
        S = scan.nextInt();
        M = scan.nextInt();

        rec_func(1);
    }

    public static void rec_func(int k) {
        if(x==E && y==S && z==M){
            System.out.println(k-1);
        }else {

            x = k % 15;
            y = k % 28;
            z = k % 19;
            if (x == 0) {
                x = 15;
            }
            if (y == 0) {
                y = 28;
            }
            if (z == 0) {
                z = 19;
            }
            rec_func(k + 1);
        }

    }


    public static void main(String[] args) {
        input();
    }

}
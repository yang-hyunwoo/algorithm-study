package bruteForce.main19532;

import java.util.Scanner;


public class Main {

    static int a,b,c,d,e,f;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();
        e = scan.nextInt();
        f = scan.nextInt();

        for(int i = -999 ; i<=999;i++) {
            for(int j = -999; j<=999;j++) {
                if((a*i)+(b*j)==c && (d*i)+(e*j)==f){
                    System.out.println(i+" "+j);
                }
            }
        }

    }


    public static void main(String[] args) {
        input();
    }

}
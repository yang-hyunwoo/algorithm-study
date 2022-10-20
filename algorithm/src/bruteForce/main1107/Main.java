package bruteForce.main1107;

import java.util.Scanner;

/*
 다시풀어보기..
 */
public class Main {

    static int N,M;
    static boolean[] breakn ;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        breakn = new boolean[10];
        for(int i = 0 ; i < M ; i++) {
            int n = scan.nextInt();
            breakn[n] = true;
        }

        int result = Math.abs(N-100);
        for(int i = 0 ; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0 ; j < len ;j++) {
                if(breakn[str.charAt(j)-'0']) {
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak) {
                int min = Math.abs(N-i)+len;
                result = Math.min(min,result);
            }
        }


        System.out.println(result);

    }


    public static void main(String[] args) {
        input();
    }

}
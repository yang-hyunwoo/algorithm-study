package bruteForce.main11170;

import java.util.Scanner;

public class Main {

    static int N , M ,S;

    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    public static void input(int start , int end) {
            int count = 0;
        for(int i = start ; i<= end ; i++) {
            if (String.valueOf(i).contains("0")) {
                int iLength = String.valueOf(i).length();
                String stringI = String.valueOf(i).replace("0","");
                count +=iLength -stringI.length();
            }
        }
        sb.append(count).append("\n");



    }


    public static void main(String[] args) {
        N = scan.nextInt();
        for(int i = 0 ; i < N ; i++) {
            M = scan.nextInt();
            S = scan.nextInt();
            input(M,S);
        }
        System.out.println(sb.toString());
    }


}
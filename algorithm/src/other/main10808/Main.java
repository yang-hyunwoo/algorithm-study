package other.main10808;

import java.util.Scanner;

public class Main {

    static String N;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextLine();
        Nary = new int[26];
        char a = 'a';
        for(int i = 0 ; i < N.length();i++) {
            int apl = (int)N.charAt(i)-(int)a;
            Nary[apl]++;
        }

        for(int i = 0 ; i < Nary.length;i++) {
            System.out.print(Nary[i]+" ");

        }
    }


    public static void main(String[] args) {
        input();
    }

}
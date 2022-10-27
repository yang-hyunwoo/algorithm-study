package sort.main25305;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Nary;

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new int[N];
        for(int i = 0 ; i < N ; i++) {
            Nary[i] = scan.nextInt();
        }

        Arrays.sort(Nary);

        System.out.println(Nary[N-M]);




    }


    public static void main(String[] args) {
        input();
    }

}

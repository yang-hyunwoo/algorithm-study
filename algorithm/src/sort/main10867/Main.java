package sort.main10867;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N+1];

        for(int i = 1 ; i <= N ; i++) {
            Nary[i] = scan.nextInt();
        }
    }

    public static void sort() {
        Arrays.sort(Nary , 1 , N+1);

        int A = Nary[1];
        sb.append(A).append(" ");
        for(int i = 2 ; i <= N ; i++) {
            if(Nary[i] != A) {
                A = Nary[i];
                sb.append(A).append(" ");
            }
        }
    }


    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }
}
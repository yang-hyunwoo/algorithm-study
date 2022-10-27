package bruteForce.main5618;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N];

        for (int i = 0; i < N; i++) {
            Nary[i] = scan.nextInt();
        }
        Arrays.sort(Nary);
        rec();
        System.out.println(sb);
    }

    public static void rec() {
        int count;
        for (int i = 1; i <= Nary[Nary.length-1]; i++) {
            count = 0;
            for(int j=0; j < N; j++) {
                if(Nary[j]%i==0 && Nary[j]!=0) {
                    count++;
                }
                if(count==N){
                    sb.append(i).append("\n");
                }
            }
        }
    }




    public static void main(String[] args) {
        input();
    }

}
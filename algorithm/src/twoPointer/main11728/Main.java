package twoPointer.main11728;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Nary , Mary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        Nary = new int[N+1];
        Mary = new int[M+1];

        for(int i = 1 ; i <= N ; i++){
            Nary[i] = scan.nextInt();
        }

        for(int i = 1 ; i <= M ; i++){
            Mary[i] = scan.nextInt();
        }
        two_pointer();
    }

    public static void two_pointer() {
        int left = 1 , right = 1;

        while(left <= N && right <= M){
            if(Nary[left] <= Mary[right]){
                sb.append(Nary[left++]).append(" ");
            } else {
                sb.append(Mary[right++]).append(" ");
            }
        }
        while(left <= N) {
                sb.append(Nary[left++]).append(" ");
        }
        while(right <= M ){
                sb.append(Mary[right++]).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
    }
}

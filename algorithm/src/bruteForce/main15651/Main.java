package bruteForce.main15651;

import java.util.Scanner;

public class Main {

    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[N+1];
    }

    //M 만큼 selected에 넣고  M만큼 for 문을 돈다.
    public static void rec_func(int k) {
        if(k == M+1) {
            for(int i = 1 ; i <= M ; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }else {
            for(int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k+1); //재귀 함수 수 끝나면 k = 1로 변환
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

}

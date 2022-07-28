package bruteForce.main15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] selected,answer;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[N+1];
        answer = new int[M+1];
        for(int i = 1 ; i <= N; i++) {
            selected[i] = scan.nextInt();
        }

        Arrays.sort(selected);
    }

    public static void rec_func(int k) {
        if(k==M+1) {
            for(int i = 1 ; i <=M ; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int cand = 1 ; cand <= N ; cand++) {
                boolean isUsed = false;
                for(int i = 1 ; i < k ; i++) {
                    if(answer[i] > selected[cand]) {
                        isUsed = true;
                    }
                }
                if(!isUsed) {
                    answer[k] = selected[cand];
                    rec_func(k+1);
                    answer[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}
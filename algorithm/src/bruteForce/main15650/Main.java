package bruteForce.main15650;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1] ;
    }

    public static void rec_func(int k) {

        if(k == M+1) {
            for(int i = 1 ; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int cand = 1 ; cand <= N ; cand++) {
                boolean isUsed = false;
                for(int i = 1 ; i < k ; i++) {
                    if(cand <= selected[i]) {
                        isUsed = true;
                    }
                }
                if(!isUsed) {
                    selected[k] = cand;
                    rec_func(k+1);
                    selected[k] = 0;
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

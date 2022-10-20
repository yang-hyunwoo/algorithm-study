package bruteForce.main10974;

import java.util.Scanner;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        visited = new boolean[N+1];
        selected = new int[N+1];

        rec_func(1);
        System.out.println(sb);
    }

    public static void rec_func(int k) {
        if(k==N+1) {
            for(int i = 1 ; i < k ; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int cand = 1 ; cand <= N ; cand++) {
                if(!visited[cand]) {
                    visited[cand] = true;
                    selected[k] = cand;
                    rec_func(k+1);
                    visited[cand] = false;
                }

            }
        }
    }


    public static void main(String[] args) {
        input();
    }

}

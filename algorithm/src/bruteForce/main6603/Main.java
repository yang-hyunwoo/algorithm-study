package bruteForce.main6603;

import java.util.Scanner;

public class Main {

    static int N,M, start;
    static int[] Nary,selected;
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);


    public static void input() {

        Nary = new int[N+1];
        selected = new int[7];
        for(int i = 1 ; i <= N ; i++) {
            Nary[i] = scan.nextInt();
        }
    }

    static void rec_func(int k) {
        if(k==7) {
            for(int i=1;i<k;i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int cand=1; cand<=N; cand++) {
                boolean isUsed = false;
                for(int i = 1 ; i < k ; i++) {
                    if(Nary[cand] <= selected[i]) {
                        isUsed = true;
                    }
                }
                if(!isUsed) {
                    selected[k] = Nary[cand];
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        while(true) {
            N = scan.nextInt();
            if(N==0) {
                break;
            }
            input();
            rec_func(1);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
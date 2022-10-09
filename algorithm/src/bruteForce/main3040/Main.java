package bruteForce.main3040;

import java.util.Scanner;

public class Main {

    static int[] Nary;

    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        Nary = new int[9];
        visit = new boolean[9];
        for(int i = 0 ; i < 9;i++){
            Nary[i] = scan.nextInt();
        }

        rec_func(0);
        System.out.println(sb.toString());
    }

    public static void rec_func(int k) {
        if(k==7) {
            int sum = 0;
            for(int i = 0 ; i < 9 ; i++){
                if(visit[i]){
                    sum += Nary[i];
                }
            }
            if( sum==100){
                sb.setLength(0);
                for(int i = 0 ; i < 9 ; i++){
                    if(visit[i]){
                        sb.append(Nary[i]).append("\n");
                    }
                }
            }
        } else {
            for(int cand = 0 ; cand < 9 ; cand++) {
                if(visit[cand]){
                    continue;
                }
                    visit[cand] = true;
                    rec_func(k+1);
                    visit[cand] = false;
            }
        }
    }

    public static void main(String[] args) {
        input();
    }

}
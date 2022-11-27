package bruteForce.main2961;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] sour;
    static int[] bitter;
    static int res = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        sour = new int[N];
        bitter = new int[N];

        for(int i = 0 ; i < N ; i++) {
            sour[i] = scan.nextInt();
            bitter[i] = scan.nextInt();
        }
        rec_func(0, 0, 1, 0);
        System.out.println(res);
    }

    public static void rec_func(int input_cnt , int cnt , int sour_sum , int bitter_sum) {
        if(cnt == N) {
            if(input_cnt!=0) {
                res = Math.min(res, Math.abs(sour_sum - bitter_sum));
            }
            return ;
        }
        rec_func(input_cnt, cnt + 1, sour_sum, bitter_sum);
        rec_func(input_cnt + 1, cnt + 1, sour_sum * sour[cnt], bitter_sum + bitter[cnt]);
    }




    public static void main(String[] args) {
        input();
    }

}
package bruteForce.main14888;

import java.util.Scanner;

public class Main {

    static int N,max,min;
    static int[] operation,M,order;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = new int[N+1];
        order = new int[N+1];
        operation = new int[5];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; i++) {
            M[i] = scan.nextInt();
        }
        for(int i = 1 ; i < 5; i++) {
            operation[i] = scan.nextInt();
        }
    }

    public static int calculator() {
        int value = M[1];
        for(int i = 1 ; i <N;i++) {
            if(order[i]==1) {
                value = value + M[i+1];
            }
            if(order[i]==2) {
                value = value - M[i+1];
            }
            if(order[i]==3) {
                value = value * M[i+1];
            }
            if(order[i]==4) {
                value = value / M[i+1];
            }
        }

        return value;
    }

    public static void rec_func(int k) {
        if(k == N) {
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else {
            for(int cand = 1 ; cand <=4;cand++) {
                if(operation[cand]>=1) {
                    operation[cand]--;
                    order[k] = cand;
                    rec_func(k+1);
                    operation[cand]++;
                    order[k] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(max+" "+min);
    }
}
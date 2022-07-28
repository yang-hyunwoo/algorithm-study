package bruteForce.main15658;

import java.util.Scanner;

public class Main {

    static int N,max,min;
    static int[] operator,nums,order;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        operator = new int[5];
        nums = new int[N+1];
        order = new int[N+1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N; i++) {
            nums[i] = scan.nextInt();
        }

        for(int i = 1 ; i <= 4 ; i++) {
            operator[i] = scan.nextInt();
        }
    }

    public static int calculator() {
        int value = nums[1];
        for(int i = 1 ; i <= N-1;i++) {
            if(order[i]==1) {
                value = value + nums[i+1];
            }
            if(order[i]==2) {
                value = value - nums[i+1];
            }
            if(order[i]==3) {
                value = value * nums[i+1];
            }
            if(order[i]==4) {
                value = value / nums[i+1];
            }
        }
        return value;

    }

    public static void rec_func(int k) {
        if(k == N) {
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for(int cand = 1 ; cand <= 4; cand++) {
                if(operator[cand]>=1) {
                    operator[cand]--;
                    order[k] = cand;
                    rec_func(k+1);
                    operator[cand]++;
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
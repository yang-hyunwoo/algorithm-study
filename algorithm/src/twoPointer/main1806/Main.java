package twoPointer.main1806;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            Nary[i] = scan.nextInt();
        }
        two_pointer();
    }

    public static void two_pointer() {
        int R = 0 , ans = Integer.MAX_VALUE , sum=0;
        for(int i = 1 ; i <= N ; i++){
            sum -= Nary[i-1];
            while(R < N && sum < M){
                R++;
                sum +=Nary[R];
            }
            if(sum >= M){
                ans = Math.min(ans ,R-i+1);
            }
        }
        if(ans==Integer.MAX_VALUE){
            ans = 0;
        }
        System.out.println(ans);

    }


    public static void main(String[] args) {
        input();
    }

}

package twoPointer.main15565;

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
        for(int i = 1 ; i <= N ;  i++) {
            Nary[i] = scan.nextInt();
        }
        two_pointer();
    }

    public static void two_pointer() {
        int R = 0 , sum = 0 , ans = Integer.MAX_VALUE;

        for(int L = 1 ; L <= N ;  L++){
            while(R < N && sum < M) {      //R을 M개 갯수만큼 옮기기
                R++;
                if(Nary[R] == 1){
                    sum++;
                }
            }
            if(sum >= M) {
                ans = Math.min(ans, (R - L + 1));
            }
            if(Nary[L] == 1){             //만약 1이면 - 해주기
                sum--;
            }
        }
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
    }

}

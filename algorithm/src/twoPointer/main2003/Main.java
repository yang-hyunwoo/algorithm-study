package twoPointer.main2003;

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
        int R = 0 , sum = 0 , count = 0;

        for(int L = 1 ; L <= N ; L++) {
            sum -= Nary[L-1];          //L -- 하기
            while(R < N && sum < M) {   //R 이 N 보다 커지거나 합이 M이 커질때 까지
                R++;                    //R 증가 시키기
                sum += Nary[R];
            }
            if(sum == M){
                count++;
            }
        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        input();
    }
}

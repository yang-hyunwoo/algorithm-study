package greedy.main11047;

import java.util.Scanner;

public class Main {

    static int N,M,sum,max = 0;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M =scan.nextInt();

        Nary = new int[N];

        for(int i = 0 ; i < N ; i++) {
            Nary[i] = scan.nextInt();
        }

        greedy();
    }

    public static void greedy() {
        while(M!=0) {                               //M이 0이 될때까지 반복
            for(int i = 0 ; i < N ; i++) {
                if(Nary[i] <=M) {                       //만약 M이 더 크다면
                    max = Math.max(max , Nary[i]);      //MAX를 변경
                }
            }
            sum += M/max;                               //나눈 횟수
            M = M % max;                                //나머지를 M에 대입
            max = 0 ;                                   //MAX 값을 0으로 초기화
        }

        System.out.println(sum);
    }


    public static void main(String[] args) {
        input();
    }

}
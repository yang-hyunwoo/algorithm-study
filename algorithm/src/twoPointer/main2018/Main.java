package twoPointer.main2018;

import java.util.Scanner;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        two_pointer();
    }

    public static void two_pointer() {
        int sum =0;
        int count = 0 ;
        int end = 1;
        for(int start = 1;  start <= N ; start++) {
            while(sum <=N) {
                if(sum==N){
                    count++;
                }
                sum += end;
                end++;
            }
            sum -= start;
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
        input();
    }

}
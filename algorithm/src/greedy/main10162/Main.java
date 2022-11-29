package greedy.main10162;

import java.util.Scanner;


public class Main {

    static int N;
    static int[] time = {300, 60, 10};
    static int[] answer;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        answer = new int[3];
        boolean chk = false;
        if(N>=300){
            answer[0] = N/time[0];
            N -= 300*answer[0];
        }
        if(N>=60){
            answer[1] = N/time[1];
            N -= 60*answer[1];
        }
        if(N%10!=0){
            System.out.println(-1);
        } else {
            answer[2] = N/time[2];
            for(int i = 0 ; i < answer.length;i++) {
                System.out.print(answer[i]+" ");
            }
        }


    }


    public static void main(String[] args) {
        input();
    }

}
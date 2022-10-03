package dynamicProgramming.main1463;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Dy;
    static StringBuilder sb = new StringBuilder();


    public static void preprocess() {
        Dy = new int[1000005];
        Dy[1] = 0;
        Dy[2] = 1;
        Dy[3] = 1;

        for(int i = 4 ; i <=1000004; i++) {
            Dy[i] = Dy[i-1]+1;
            if(i % 6 ==0) {
                Dy[i] = Math.min(Dy[i],(Math.min(Dy[i / 3], Dy[i / 2]))+1);
            } else if(i % 3==0) {
                Dy[i] = Math.min(Dy[i],Dy[i/3]+1);

            }else if(i % 2 ==0) {
                Dy[i] = Math.min(Dy[i],Dy[i/2]+1);
            }
        }

    }

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        System.out.println(Dy[N]);

    }


    public static void main(String[] args) {
        preprocess();
        input();
    }

}
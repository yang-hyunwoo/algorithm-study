package twoPointer.main10025;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class Elem implements Comparable<Elem> {
        int x;      //좌표
        int ice;      //얼음

        @Override
        public int compareTo(Elem o) {
            return x-o.x;
        }
    }

    static int N,M;
    static Elem[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new Elem[N + 1];

        for(int i = 1; i <= N ; i++) {
            Nary[i] = new Elem();
            Nary[i].ice = scan.nextInt();
            Nary[i].x = scan.nextInt();
        }
        two_pointer();
    }

    public static void two_pointer() {
        Arrays.sort(Nary,1,N+1);

        int start = 1 , end = 1,sum = 0,max=0;
        int d = 2*M +1;

        while(end <= N) {
            if(Nary[end].x - Nary[start].x <= d) {
                sum += Nary[end++].ice;
                max = Math.max(max, sum);
            } else {
                sum -= Nary[start++].ice;
            }
        }
        System.out.println(max);
    }


    public static void main(String[] args) {
        input();
    }

}
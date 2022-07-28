package sort.main1015;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] ary;
    static Elem[] ary2;
    static int[] P;
    public static class Elem implements Comparable<Elem>{
        public int num,idx;
        @Override
        public int compareTo(Elem other) {
            return num - other.num;
        }
    }

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N 	 = scan.nextInt();
        ary2 = new Elem[N];
        P 	 = new int[N];
        for(int i = 0 ; i < N ; i++) {
            ary2[i] = new Elem();
            ary2[i].num = scan.nextInt();
            ary2[i].idx = i;
        }
    }

    public static void run() {
        Arrays.sort(ary2);
        for(int i = 0 ; i < N; i++) {
            P[ary2[i].idx] = i;
        }
        for(int i = 0 ; i < N; i++) {
            System.out.println(P[i]);
        }
    }

    public static void main(String[] args) {
        input();
        run();
    }
}
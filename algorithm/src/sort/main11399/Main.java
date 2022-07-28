package sort.main11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static class Elem implements Comparable<Elem> {     //정렬 하는 클래스 생성
        int X;
        int time;

        @Override
        public int compareTo(Elem o) {          //비교
            return time -o.time ;
        }
    }

    static int N;
    static Elem[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new Elem[N+1];
        for(int i = 1 ; i <= N ; i++){
            Nary[i] = new Elem();
            Nary[i].X = i;
            Nary[i].time = scan.nextInt();
        }
    }

    static void sort() {
        Arrays.sort(Nary,1,N+1);        //정렬
        int sum = Nary[1].time;                         //1~.....N+1 값
        int total = sum;                                //총 기다린 시간
        for(int i = 2 ; i <= N ; i++) {
            sum = sum+=Nary[i].time;
            total +=sum;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        input();
        sort();
    }
}
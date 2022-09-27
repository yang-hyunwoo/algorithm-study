package sort.main2822;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Elem implements Comparable<Elem> {
        int que;
        int score;


        @Override
        public int compareTo(Elem o) {
            return o.score-score;
        }
    }
    static int N;
    static Elem[] Nary;
    static int[] scoreAry;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        Nary = new Elem[9];
        scoreAry = new int[6];
        for (int i = 1; i <= 8; i++) {
            Nary[i] = new Elem();
            Nary[i].que = i;
            Nary[i].score = scan.nextInt();
        }

        sort();
    }

    public static void sort() {
        Arrays.sort(Nary,1,9);          //점수 내림차순으로 정렬

        int sum = 0;                                    //점수 합

        for(int i = 1; i <= 5 ; i++) {                  //점수 높은 순 5개 점수 더하기
            sum += Nary[i].score;
            scoreAry[i] = Nary[i].que;                  //점수의 문제 배열에 넣기
        }

        sb.append(sum).append("\n");
        Arrays.sort(scoreAry,1,6);      //점수의 문제 오름차순으로 정렬
        for(int i = 1; i <= 5 ; i++) {
            sb.append(scoreAry[i]).append(" ");
        }

    }


    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());
    }

}
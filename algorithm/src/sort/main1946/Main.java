package sort.main1946;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Elem implements Comparable<Elem> {
        int one;
        int two;


        @Override
        public int compareTo(Elem o) {
            return one-o.one;
        }
    }

    static int N,M,count;
    static Elem[] Nary;

    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    public static void input() {
          M = scan.nextInt();
          Nary = new Elem[M+1];
          for(int i = 1 ; i <= M ; i++){
              Nary[i] = new Elem();
              Nary[i].one = scan.nextInt();
              Nary[i].two = scan.nextInt();
          }

        Arrays.sort(Nary,1,M+1);                //정렬

        proc();
    }

    public static void proc() {
        count = 1;                                              //Nary[1] 포함
        int score = Nary[1].two;
        int j = 2;
        while (j <= M) {
            if (score > Nary[j].two) {
                score = Nary[j].two;                            //score 를 변경 해준다.
                count++;
            }
            j++;
        }
        sb.append(count).append("\n");

    }


    public static void main(String[] args) {
        N = scan.nextInt();
        for(int i = 1 ; i <= N ; i++){
            input();

        }
        System.out.println(sb.toString());
    }

}
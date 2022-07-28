package sort.main1931;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static class Elem implements Comparable<Elem> {
        int Start;
        int End;



        @Override
        public int compareTo(Elem o) {
            if(o.End == End){           //종료 시간이 같다면 시작시간을 먼저 정렬 한다.
                return Start - o.Start;
            } else {
                return End - o.End;
            }

        }
    }
    static int N;
    static Elem[] Nary;
    static StringBuilder sb = new StringBuilder();

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new Elem[N+1];
        scan.nextLine();
        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(scan.nextLine());
            while(st.hasMoreTokens()) {
                Nary[i] = new Elem();
                Nary[i].Start = Integer.parseInt(st.nextToken());
                Nary[i].End = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void sort() {        //정렬
        Arrays.sort(Nary , 1 , N+1);
        int count =0;
        int prev_end_time = 0;
        for(int i = 1 ; i <= N ; i++){
            if(prev_end_time <= Nary[i].Start){
                prev_end_time = Nary[i].End;
                count++;
            }
        }
        sb.append(count);
    }


    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }

}
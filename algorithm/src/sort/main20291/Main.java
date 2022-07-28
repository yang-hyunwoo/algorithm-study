package sort.main20291;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static String[] ary;

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        ary = new String[N];
        scan.nextLine();
        for(int i = 0 ; i < N; i++) {
            ary[i] = scan.nextLine().split("\\.")[1];
        }
    }

    public static void run() {
        Arrays.sort(ary);
        for(int i = 0 ; i < N; i++) {
            int count = 1;
            int k = i+1;
            for(int j = k; j < N; j++) {
                if(ary[j].compareTo(ary[i])==0) {
                    count++;
                }else {
                    break;
                }
                i = j;
            }
            System.out.println(ary[i]+" "+count);
        }
    }

    public static void main(String[] args) {
        input();
        run();
    }
}
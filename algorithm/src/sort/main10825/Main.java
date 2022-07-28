package sort.main10825;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static Elem[] ary;
    public static class Elem implements Comparable<Elem>{

        String name;
        int korean,english,math;

        @Override
        public int compareTo(Elem other) {
            if(other.korean != korean) {
                return other.korean - korean;
            }
            if(other.english != english) {
                return english - other.english;
            }
            if(other.math != math) {
                return other.math - math;
            }
            return name.compareTo(other.name);
        }
    }


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        ary = new Elem[N];
        for(int i = 0; i < N; i++) {
            ary[i] = new Elem();
            ary[i].name 	= scan.next();
            ary[i].korean   = scan.nextInt();
            ary[i].english  = scan.nextInt();
            ary[i].math 	= scan.nextInt();
        }

    }

    public static void run() {
        Arrays.sort(ary);
        for(int i = 0 ; i < N ; i++) {
            System.out.println(ary[i].name);
        }
    }

    public static void main(String[] args) {
        input();
        run();

    }

}
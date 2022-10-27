package sort.main2075;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {

    static int N;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < (N*N) ; i++) {
            int a = scan.nextInt();
            queue.add(a);
        }
        for(int i = 0 ; i < N-1 ; i++){
            queue.poll();
        }
        System.out.println(queue.poll());
    }


    public static void main(String[] args) {
        input();
    }

}

package dfsBfs.main25418;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] dist;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[1000005];
        dist = new int[1000005];

        bfs();
        System.out.println(dist[M]);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if(x+1 <=1000000 && !visited[x+1]){
                visited[x+1] = true;
                dist[x+1] = dist[x]+1;
                queue.add(x+1);
            }
            if(x*2 <=1000000 && !visited[x*2]){
                visited[x*2] = true;
                dist[x*2] = dist[x]+1;
                queue.add(x * 2);
            }
        }
    }


    public static void main(String[] args) {
        input();
    }

}
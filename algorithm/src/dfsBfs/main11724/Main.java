package dfsBfs.main11724;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static ArrayList<Integer>[] Nary;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i = 1 ; i <= N ; i++){
            Nary[i] = new ArrayList<Integer>();
        }
        for(int i = 1 ; i <= M ; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            Nary[x].add(y);
            Nary[y].add(x);
        }
            int count = 0;
        for(int i =1 ; i <= N; i++){
            if(!visit[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visit[x] = true;
        while (!queue.isEmpty()) {
            x = queue.poll();
            for(int y : Nary[x]){
                if(visit[y]){
                    continue;
                }
                queue.add(y);
                visit[y] =true;
            }
        }


    }


    public static void main(String[] args) {
        input();
    }

}
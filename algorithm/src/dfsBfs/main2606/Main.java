package dfsBfs.main2606;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N,M,count;
    static ArrayList<Integer>[] adj ;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i = 1 ; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= M ; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        for(int i = 1; i <= N ; i++){
            Collections.sort(adj[i]);
        }
        dfs(1);
    }

    public static void dfs(int A){
        visit[A] = true;
        count++;
        for(int y: adj[A]){
            if(visit[y]){
                continue;
            }
            dfs(y);
        }

    }


    public static void main(String[] args) {
        input();
        System.out.println(count-1); //COUNT 된것은 자기 자신을 포함 하기 때문에 1을 빼준다.
    }

}
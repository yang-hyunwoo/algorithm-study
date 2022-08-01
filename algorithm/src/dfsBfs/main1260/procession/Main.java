package dfsBfs.main1260.procession;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M,S;
    static int[][] Nary;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        S = scan.nextInt();
        Nary = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i = 1 ; i <= M ; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            Nary[x][y] = 1;
            Nary[y][x] = 1;
        }
        dfs(S);
        System.out.println(sb.toString());
        sb.setLength(0);
        for(int i = 1 ; i <=N ; i++){
            visit[i] = false;
        }
        bfs(S);
        System.out.println(sb.toString());

    }

    public static void dfs(int X){
        visit[X] = true;
        System.out.println("asdfsadfasdfasdf");
        sb.append(X).append(" ");
        for(int y = 1 ; y <= N ; y++){
            if(Nary[X][y]==0){
                continue;
            }
            if(visit[y]){
                continue;
            }
            dfs(y);
        }
    }

    public static void bfs(int X){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        visit[X] = true;
        while(!queue.isEmpty()){
            X = queue.poll();
            sb.append(X).append(" ");
            for(int y = 1 ; y <= N ; y++){
                if(Nary[X][y]==0){
                    continue;
                }
                if(visit[y]){
                    continue;
                }
                queue.add(y);
                visit[y]=true;
            }
        }
    }

    public static void main(String[] args) {
        input();
    }

}
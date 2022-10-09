package dfsBfs.main1260.arrayList;

import java.util.*;

public class Main {

    static int N,M,S;
    static ArrayList<Integer>[] Nary;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        S = scan.nextInt();
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

        for(int i = 1 ; i <=N ; i++){
            Collections.sort(Nary[i]);
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
        sb.append(X).append(" ");
        for(int y: Nary[X]){
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
            for(int y:Nary[X]){
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
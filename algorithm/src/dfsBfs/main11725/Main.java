package dfsBfs.main11725;

import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] Nary;
    static boolean[] visit;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new ArrayList[N+1];
        visit = new boolean[N+1];
        parent = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            Nary[i] = new ArrayList<Integer>();
        }
        for(int i = 1 ; i < N ; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            Nary[x].add(y);
            Nary[y].add(x);
        }
        for(int i = 1 ; i < N ; i++){
            Collections.sort(Nary[i]);
        }
//        dfs(1);
        bfs(1);
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int y : Nary[x]){
                if(visit[y]){
                    continue;
                }
                queue.add(y);
                parent[y] = x;
                visit[y] = true;
            }
        }
    }

    public static void dfs(int X){
        visit[X] =true;
        for(int y : Nary[X]){
            if(visit[y]){
                continue;
            }
            parent[y] = X;
            dfs(y);
        }
    }


    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());
    }
}

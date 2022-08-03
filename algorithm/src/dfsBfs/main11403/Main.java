package dfsBfs.main11403;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;

    static int[][] Nary;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N][N];
        visit = new boolean[N];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                Nary[i][j] = scan.nextInt();
            }
        }
        for(int i = 0 ; i < N ; i++){
            /*
             * bfs
             * */
            bfs(i);

            /*
             * dfs
             * */
            dfs(i);
            reset();

        }
    }
    static void reset() {
        for(int i = 0 ; i < N ; i++){
            sb.append(visit[i]? 1 : 0).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < N; i++)
        {
            visit[i] = false;
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++)
        {
            visit[i] = false;
        }

        queue.add(x);
        visit[x] = false;

        while(!queue.isEmpty()){
            int q = queue.poll();

            for(int y = 0 ; y < N ; y++){
                if(Nary[q][y]==0){
                    continue;
                }
                if(visit[y]){
                    continue;
                }
                queue.add(y);
                visit[y] = true;
            }
        }
        for(int i = 0 ; i < N ; i++){
            sb.append(visit[i]? 1 : 0).append(" ");
        }
        sb.append("\n");
    }

    public static void dfs(int x) {

       for(int i = 0 ; i < N ; i++){
           if(Nary[x][i]==0){
               continue;
           }
           if(visit[i]){
               continue;
           }
           visit[i] = true;
            dfs(i);
       }
    }


    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());
    }
}

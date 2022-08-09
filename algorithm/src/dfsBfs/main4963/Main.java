package dfsBfs.main4963;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] Nary;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};    static StringBuilder sb = new StringBuilder();
    static int count= 0 ;
    static  Scanner scan = new Scanner(System.in);
    public static void input(int N , int M) {


        Nary = new int[M + 1][N + 1];
        visit = new boolean[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                Nary[i][j] = scan.nextInt();
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if(!visit[i][j] && Nary[i][j] ==1) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
        count=0;
    }

    public static void dfs(int x,int y){
        visit[x][y] = true;

        for(int k = 0 ; k < 8 ; k++) {
            int nx = x+dir[k][0];
            int ny = y+dir[k][1];
            if(nx < 0 || ny <0 || nx > M || ny > N){
                continue;
            }
            if(Nary[nx][ny] ==0){
                continue;
            }
            if(visit[nx][ny]){
                continue;
            }
            dfs(nx,ny);
        }
     }

    public static void main(String[] args) {
        while(true) {
            N = scan.nextInt();
            M = scan.nextInt();
            if(N == 0 && M ==0){
                break;
            }
            input(N,M);
        }
    }
}

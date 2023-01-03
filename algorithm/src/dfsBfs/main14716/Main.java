package dfsBfs.main14716;

import java.util.Scanner;

public class Main {

    static int N,M,count;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    static int[][] Nary;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Nary[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i < N ; i++) {
            for(int j = 0 ; j < M ;j++) {
                if(!visited[i][j] && Nary[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x , int y) {
        visited[x][y] = true;
        for(int k = 0 ; k <8;k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx <0 || ny <0 || ny >= M || nx >= N ) continue;
            if(Nary[nx][ny] == 0) continue;
            if(visited[nx][ny]) continue;
            dfs(nx, ny);
        }


    }


    public static void main(String[] args) {
        input();
    }

}

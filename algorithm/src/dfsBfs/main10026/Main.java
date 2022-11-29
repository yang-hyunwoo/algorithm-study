package dfsBfs.main10026;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] Nary;
    static boolean[][] visit;
    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        Nary = new char[N][N];
        visit = new boolean[N][N];
        for(int i = 0 ; i < N ; i++) {
            String a = scan.nextLine();
            for(int j = 0 ; j < a.length();j++){
                Nary[i][j] = a.charAt(j);
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int one = cnt;
        cnt = 0;

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(Nary[i][j]=='G') {
                    Nary[i][j] = 'R';
                }
                visit[i][j] = false;
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        int two = cnt;
        System.out.println(one+" "+two);
    }

    public static void dfs(int x , int y) {
        visit[x][y] = true;
        char tmp_char = Nary[x][y];

        for(int k = 0 ; k < 4 ; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx < 0 || ny < 0 || ny >= N || nx >= N) continue;
            if(!visit[nx][ny] && Nary[nx][ny] == tmp_char) {
                dfs(nx, ny);
            }
        }
    }


    public static void main(String[] args) {
        input();
    }

}

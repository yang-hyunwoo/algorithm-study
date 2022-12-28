package dfsBfs.main1388;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N,M,count;
    static int[] dir = {1, -1}; //방향
    static char[][] Nary;
    static boolean[][] visited;

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new char[N][M];
        visited = new boolean[N][M];
        scan.nextLine();
        for(int i = 0 ; i < N ; i++) {
            String a = scan.nextLine();
            for(int j = 0 ; j<a.length();j++) {
                Nary[i][j] = a.charAt(j);
            }
        }

        pro();
        System.out.println(count);
    }

    private static void pro() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(!visited[i][j] && Nary[i][j]=='-') {
                    dfs(i,j,'-');
                        count++;
                }
                if(!visited[i][j] && Nary[i][j]=='|') {
                    dfs(i,j,'|');
                    count++;
                }
            }
        }
    }

    private static void dfs(int x, int y, char c) {

        visited[x][y] = true;

        for(int k = 0 ; k <2;k++) { // -(앞,옆) | (위 ,아래) 구하기
            if(c=='-') {
                int ny = y + dir[k];
                if (ny < 0 || ny >= M) continue;
                if (Nary[x][ny] != c) continue;
                if (visited[x][ny]) continue;
                dfs(x, ny, c);
            }
            if(c=='|') {
                int nx = x + dir[k];
                if (nx < 0 || nx >= N) continue;
                if (Nary[nx][y] != c) continue;
                if (visited[nx][y]) continue;
                dfs(nx, y, c);
            }
        }
    }


    public static void main(String[] args) {
        input();
    }

}
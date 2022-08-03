package dfsBfs.main1012;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N,M,V,cnt;
    static int[][] earth;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    public static void input() {

        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();

        earth = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0 ; i < V ; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            earth[x][y] = 1;
        }
    }

    public static void pro() {
        group = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visit[i][j] && earth[i][j] == 1){
                    cnt = 0;
                    dfs(i,j);
                    group.add(cnt);
                }
            }
        }
        System.out.println(group.size());
    }

    public static void dfs(int x , int y) {
        cnt++;
        visit[x][y] = true;

        for(int k = 0 ; k <4 ; k++){
            int nx = x+dir[k][0];
            int ny = y+dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >=M){
                continue;
            }

            if(earth[nx][ny]==0){
                continue;
            }
            if(visit[nx][ny]){
                continue;
            }
            dfs(nx,ny);
        }

    }


    public static void main(String[] args) {
        int a = scan.nextInt();
        int i = 0;
        while(i <a){
            input();
            pro();
            i++;
        }
    }

}
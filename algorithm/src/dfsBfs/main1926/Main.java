package dfsBfs.main1926;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N,M , group_cnt;

    static boolean[][] visit;

    static int[][] Nary;

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static ArrayList<Integer> group;


    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                Nary[i][j] = scan.nextInt();
            }
        }
        visit = new boolean[N][M];
        pro();
    }

    public static void pro() {
        group = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(!visit[i][j] && Nary[i][j]==1) {
                    group_cnt = 0 ;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }
        if(group.size()==0){
            sb.append(0).append("\n");
            sb.append(0);
        }else {
            Collections.sort(group);
            sb.append(group.size()).append("\n");
            sb.append(group.get(group.size() - 1));

        }

        System.out.println(sb);
    }

    public static void dfs(int x , int y) {
        group_cnt++;
        visit[x][y] = true;

        for(int k = 0 ; k < 4 ; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >=M) continue;
            if(Nary[nx][ny]==0) continue;
            if(visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }


    public static void main(String[] args) {
        input();
    }

}

package dfsBfs.main2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N,group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;


    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        a = new String[N];
        scan.nextLine();
        for(int i = 0 ; i < N ; i++){
            a[i] = scan.nextLine();
        }
        visit = new boolean[N][N];

    }

    public static void pro() {
        group = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visit[i][j] && a[i].charAt(j) == '1'){
                    group_cnt = 0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for(int cnt:group){
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int x , int y){
        group_cnt++;
        visit[x][y] = true;

        for(int k = 0 ; k < 4 ; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx < 0 || ny < 0 || ny >= N || nx >= N) continue;
            if(a[nx].charAt(ny) == '0') continue;    //0인지 체크
            if(visit[nx][ny]) continue;             //방문여부 체크
            dfs(nx,ny);
        }

    }


    public static void main(String[] args) {
        input();
        pro();
    }

}
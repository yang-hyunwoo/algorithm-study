package dfsBfs.main14502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M,B,ans;

    static int[][] room , blank;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        room = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M+ 1];
        blank = new int[N * M + 1][2];
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                room[i][j] = scan.nextInt();
            }
        }
    }

    public static void rec_func(int idx , int selected_cnt){
        if(selected_cnt == 3) {
            bfs();
            return ;
        }
        if(idx > B){
            return ;
        }
        room[blank[idx][0]][blank[idx][1]] = 1;
        rec_func(idx + 1, selected_cnt + 1);


        room[blank[idx][0]][blank[idx][1]] = 0;
        rec_func(idx + 1, selected_cnt);
    }

    public static void bfs() {
         Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;
                if (room[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                    visit[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int k = 0 ; k < 4 ; k++){
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (room[nx][ny] != 0) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++){
                if (room[i][j] == 0 && !visit[i][j]) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    public static void pro() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (room[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }
        rec_func(1,0);
        System.out.println(ans);
    }


    public static void main(String[] args) {
        input();
        pro();
    }

}
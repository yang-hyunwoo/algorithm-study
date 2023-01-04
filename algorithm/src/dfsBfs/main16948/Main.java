package dfsBfs.main16948;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N; //체스판 크기

    static int[][] dist; //이동 횟수
    static boolean[][] visited; //방문 여부
    static int[][] dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}}; //데스나이트
    static int deathKnightX,deathKnightY,endDeathKnightX,endDeathKnightY;


    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        deathKnightX = scan.nextInt();
        deathKnightY = scan.nextInt();
        endDeathKnightX = scan.nextInt();
        endDeathKnightY = scan.nextInt();
        dist = new int[N][N];
        visited = new boolean[N][N];

        bfs(deathKnightX, deathKnightY);

        System.out.println(dist[endDeathKnightX][endDeathKnightY]==0?-1:dist[endDeathKnightX][endDeathKnightY]);

    }

    private static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);

        while (!queue.isEmpty()) {
            int xx = queue.poll();
            int yy = queue.poll();
            for(int k = 0 ; k < 6 ; k++){
                int nx = xx + dir[k][0];
                int ny = yy + dir[k][1];
                if(nx < 0 || ny <0 || nx >= N || ny>= N) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[xx][yy] +1;
            }
        }

    }


    public static void main(String[] args) {
        input();
    }

}
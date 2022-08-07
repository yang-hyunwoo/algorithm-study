package dfsBfs.main2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static String[] Nary;
    static int[][] dist;
    static int[][] dir =  {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        Nary = new String[N];
        dist = new int[N][M];
        scan.nextLine();

        for(int i = 0 ; i < N ; i++){
            Nary[i] = scan.nextLine();
        }
            bfs(0,0);
    }

    public static void bfs(int x , int y) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < N ; i++){           //dist 초기화 해준다.
            for(int j = 0 ; j < M ; j++){
                dist[i][j] = -1;
            }
        }

        queue.add(x);
        queue.add(y);

        dist[x][y] = 1;     //1부터 밟았다고 시작

        while(!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();

            for(int k = 0 ; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(Nary[nx].charAt(ny) == '0') continue;        //다음 칸으로 갈수 있는가 체크
                if(dist[nx][ny]>-1) continue;
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y]+1;
            }
        }



    }



    public static void main(String[] args) {
        input();
        System.out.println(dist[N - 1][M - 1]);
    }

}
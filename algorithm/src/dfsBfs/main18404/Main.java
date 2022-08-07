package dfsBfs.main18404;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] Nary;
    static int[][] dir = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
    static int[][] dist;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        Nary = new int[N+1][N+1];
        dist = new int[N+1][N+1];

        int kx = scan.nextInt();
        int ky = scan.nextInt();

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <=N ; j++){
                dist[i][j] = -1;
            }
        }

        for(int i = 1 ; i <= M ; i++){
                int x = scan.nextInt();
                int y = scan.nextInt();
            bfs(kx,ky,x,y);
        }
    }

    public static void bfs(int x , int y , int z, int q){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        dist[x][y] = 0;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for(int k = 0 ; k <8; k++){
                int nx = x+dir[k][0];
                int ny = y+dir[k][1];
                if(nx <0 || ny <0 || nx > N || ny > N){
                    continue;
                }
                if(dist[nx][ny]>-1){
                    continue;
                }
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y]+1;
            }

        }
        System.out.println(dist[z][q]);

    }


    public static void main(String[] args) {
        input();
    }

}

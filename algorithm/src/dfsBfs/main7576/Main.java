package dfsBfs.main7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};           //상 하 좌 우
    static int[][] Nary;
    static int[][] dist;
    static boolean chk = false;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M =scan.nextInt();
        Nary = new int[M][N];
        dist = new int[M][N];
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                Nary[i][j] = scan.nextInt();
            }
        }

        for(int i = 0 ; i < M ; i++){               //처음 토마토가 모두 숙성되었는지 체크 다 되어있으면 0 아니면 bfs 시작
            for(int j = 0 ; j < N ; j++){
                if(Nary[i][j]==0){
                    chk = true;
                }
            }
        }

        if(chk){
            bfs();
        }else{
            System.out.println("0");
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < M ; i++){               //시작점이 여러개 일수 있으니 시작점을 먼저 큐에 담아주고  dist라는 배열을 0으로 초기 화 및 비어있는곳은 -1로 체크
            for(int j = 0 ; j < N ; j++){
                dist[i][j] = 0;
                if(Nary[i][j]==1) {
                    queue.add(i);
                    queue.add(j);
                    dist[i][j] = 1;
                }
                if(Nary[i][j]==-1){
                    dist[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for(int k = 0 ; k < 4 ; k++){                   //상 하 좌 우 를 반복 한다.
                int nx = x+dir[k][0];
                int ny = y+dir[k][1];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;               //범위 체킹
                if(dist[nx][ny]!= 0 ) {                                 //0이 아니라면 넘어감
                    continue;
                }
                dist[nx][ny] = dist[x][y]+1;
                queue.add(nx);
                queue.add(ny);
            }
        }

        int max = 0 ;
        boolean distChk = false;

        for(int i = 0 ; i < M ; i++){           //bfs 완료 후 dist의 배열의 최대값을 뽑는다 . 허나 0이 있다면 모두 숙성되지 않았으므로 -1을 리턴 하는 boolean값으로 체크 해준다.
            for(int j = 0 ; j < N ; j++){
                max = Math.max(max,dist[i][j]);
                if(dist[i][j]==0){
                    distChk=true;
                }
            }
        }
        if(distChk){
            System.out.println("-1");
        } else {
            System.out.println(max - 1);
        }
    }


    public static void main(String[] args) {
        input();
    }

}
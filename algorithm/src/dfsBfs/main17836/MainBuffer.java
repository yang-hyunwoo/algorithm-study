package dfsBfs.main17836;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainBuffer {

    static int N,M,T,knightX,knightY,min = Integer.MAX_VALUE,mid; //mid (1+2) 1.검을 찾을때까지의 거리 +2.검을 찾고 벽을 허물면서 가는 거리
    static int[][] Nary;
    static boolean[][] visited;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void input() throws IOException {
        Scanner scan = new Scanner(System.in);
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        Nary = new int[N + 1][M + 1];           //성
        visited = new boolean[N + 1][M + 1];    //방문 여부 체크
        dist = new int[N + 1][M + 1];           //거리 배열

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                Nary[i][j] = Integer.parseInt(st.nextToken());
                if(Nary[i][j]==2) {             //검일때 체크 하기
                    knightX = i;
                    knightY = j;
                }
            }
        }

        bfs(1, 1,1);        // x : x 좌표 , y: y 좌표 , chk : 체크여부 확인
        if(dist[N][M]!=0) {           //검을 안찾고 그냥 0으로만 갈때 좌표 값에서 0이 아닐때 min 값을 변경
            min = Math.min(min, dist[N][M]);
        }
        reset();                      //visited , dist 배열 초기화
        bfs(1, 1,2);        //검을 찾는 거리 bfs 실행
        mid = dist[knightX][knightY]; //검을 찾은 거리
        if(mid!=0) {                  //검을 찾은 거리가 0이 아니면
            reset();                  //visited , dist 배열 초기화
            bfs(knightX, knightY, 3); //검을 찾고 이제 벽을 허물면서 갈수 있는 bfs 실행
            mid = mid+dist[N][M];         //검을 찾은 거리 + 벽을 허물고 공주한테 간 거리
            min = Math.min(min, mid);     //min값 변경
        }
        if(min==0 || min >T){           //min이 0 이거나 min 이 T시간안에 되지 않으면 Fail
            bw.write("Fail");
        } else {
            bw.write(String.valueOf(min));
        }
        bw.flush();
        bw.close();
    }

    public static void reset() {
        for(int i = 0 ; i <= N ; i++) {
            for (int j = 0; j <= M; j++) {
                visited[i][j] = false;
                dist[i][j] = 0;
            }

        }
    }

    private static void bfs(int x, int y,int chk) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);

        while(!queue.isEmpty()) {
            int xx = queue.poll();
            int yy = queue.poll();
            for(int k = 0 ; k < 4; k++) {
                int nx = xx + dir[k][0];
                int ny = yy + dir[k][1];
                if(nx < 1 || ny < 1 || nx > N || ny >M) continue;

                if(chk==1){
                    if(visited[nx][ny] || Nary[nx][ny]!=0) continue;
                } else if(chk==2){
                    if(visited[nx][ny] || Nary[nx][ny]==1) continue;
                } else if(chk==3) {
                    if(visited[nx][ny] ) continue;
                }
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[xx][yy] +1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }

}
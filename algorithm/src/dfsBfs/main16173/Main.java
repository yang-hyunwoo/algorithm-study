package dfsBfs.main16173;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][]  Nary;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0; j < N ; j++ ) {
                Nary[i][j] = scan.nextInt();
                visited[i][j] = false;
            }
        }

        bfs(0, 0);      //bfs 시작 0,0 부터 시작
    }

    public  static void bfs(int a , int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        queue.add(b);
        visited[a][b] = true;

        while (!queue.isEmpty()) {              //큐가 비어 있지 않으면
            int x = queue.poll();
            int y = queue.poll();
            for(int k = 0 ; k < 2; k++) {       //오른쪽과 , 아래로만 진행을 하기 때문에 2번 for문 사용
                int nx=0 , ny=0 ;
                if(k==0){                       //k==0 일때 오른쪽으로 이동 시켜 보기
                    if(x+y<=N) {                //x+y가 N보다 작을 경우
                        nx = x + Nary[x][y];    //배열의 값만큼 x좌표 오른쪽으로 이동
                        ny = y;                 //오른쪽으로 이동하기 때문에 y 좌표는 움직일 필요가 없음
                    }
                }else {
                    if(x+y<=N) {
                        nx = x;                  //아래쪽으로 이동하기 때문에 x 좌표는 움직일 필요가 없음
                        ny = y + Nary[x][y];     //배열의 값만큼 y좌표 오른쪽으로 이동
                    }
                }

                if(nx < 0  || ny < 0 || nx >= N || ny >= N) continue;       //값이 넘어가면 안되기 때문에
                if(visited[nx][ny]) continue;                               //이동한곳은 무시 해야 하기 때문에

                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
            }
        }

        String ans ="";
        if(visited[N-1][N-1]){
            ans = "HaruHaru";
        }else {
            ans = "Hing";
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        input();
    }

}
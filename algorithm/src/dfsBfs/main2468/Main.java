package dfsBfs.main2468;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] Nary;
    static int[][] NaryDeep;
    static boolean[][] visit;
    static int[] nn;

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};



    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N][N];                   //scanner 받은 배열
        NaryDeep = new int[N][N];               //scanner을 받고 재배열할 배열
        visit = new boolean[N][N];              //방문 할 배열

        nn = new int[105];                      //값

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++) {
                Nary[i][j] = scan.nextInt();
            }
        }
        for(int k = 0 ; k <= 100 ; k++) {           //0~100까지 돌리면서 NaryDeep의 배열을 지문에 맞게 재배열
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Nary[i][j] > k) {           //k보다 크면 섬은 가라앉지 않고
                        NaryDeep[i][j] = 1;
                    } else {                        //k보다 작으면 섬은 가라 앉는다.
                        NaryDeep[i][j] = 0;
                    }
                }
            }
                newAry(k);                              //재배열이 완료 되면 재배열된 배열로 dfs 탐색 실행
        }

        int max = 0;
        for (int i = 0; i < nn.length; i++) {
            max = Math.max(max,nn[i]);
        }
            System.out.println(max);

    }

    public static void newAry(int k) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && NaryDeep[i][j]==1) {            //방문하지 않았고 섬이 가라않지 않았다면
                        dfs(i,j);
                        nn[k] = nn[k]+1;                                //그리고 k의 배열에 1씩 증가를 시켜준다.
                    }
                }
            }
            for (int i = 0; i < N; i++) {                              //dfs가 끊났다면 visit 배열을 초기화 함
                for (int j = 0; j < N; j++) {
                        visit[i][j] = false;
                    }
            }

        }

        public static void dfs(int x , int y){                          //dfs 시작
            visit[x][y] = true;
            for(int k = 0 ; k < 4 ; k++){                               //상하좌우탐색 시작
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || ny >= N || nx >= N) continue;
                if(NaryDeep[nx][ny] == 0) continue;    //0인지 체크
                if(visit[nx][ny]) continue;             //방문여부 체크
                dfs(nx,ny);
            }
        }




    public static void main(String[] args) {
        input();
    }

}
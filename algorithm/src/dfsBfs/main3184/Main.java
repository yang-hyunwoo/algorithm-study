package dfsBfs.main3184;

import java.util.Scanner;

public class Main {

    static int N,M;
    static String[] Nary;

    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int sheep , wolf ,totalSheep , totalWolf;
/*
 . : 빈 필드
 # : 울타리
 o : 양
 v : 늑대
 */
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();
        Nary = new String[N];
        visit = new boolean[N][M];
        for(int i = 0 ; i < N ; i++) {
            Nary[i] = scan.nextLine();
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visit[i][j] && Nary[i].charAt(j) != '#'){
                    sheep = 0;
                    wolf = 0;

                    dfs(i,j);
                    if(sheep > wolf){
                        totalSheep += sheep;
                    } else{
                        totalWolf += wolf;
                    }

                }
            }
        }
        System.out.println(totalSheep);
        System.out.println(totalWolf);
    }

    public static void dfs(int x , int y) {
        if(Nary[x].charAt(y) == 'o'){
            sheep++;
        }
        if(Nary[x].charAt(y) == 'v'){
            wolf++;
        }

        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if(Nary[nx].charAt(ny) == '#'){
                continue;
            }
            if(visit[nx][ny]){
                continue;
            }
            dfs(nx,ny);
        }

    }

    public static void main(String[] args) {
        input();
    }
}

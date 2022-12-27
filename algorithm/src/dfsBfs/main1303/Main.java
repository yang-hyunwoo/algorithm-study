package dfsBfs.main1303;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int horizontal,vertical,group_cnt;   //수직 , 수평 , 그룹 카운트
    static ArrayList<Integer> w;        //w의 갯수
    static ArrayList<Integer> b;        //b의 갯수
    static char[][] Nary;               //입력 값
    static boolean[][] visited;         //방문 여부
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};    //상하 좌우

    public static void input() {
        Scanner scan = new Scanner(System.in);
        horizontal = scan.nextInt();
        vertical = scan.nextInt();
        Nary = new char[horizontal][vertical];
        visited = new boolean[horizontal][vertical];
        scan.nextLine();

        for(int i = 0 ; i < vertical ; i++) {
            String a = scan.nextLine();
            for(int j = 0 ; j < a.length();j++) {
                Nary[j][i] = a.charAt(j);
            }
        }

        w = new ArrayList<>();
        b = new ArrayList<>();

        for(int i = 0 ; i < vertical ; i++) {
            for(int j=0; j < horizontal ; j++) {
                group_cnt = 0;
                if(!visited[j][i] && Nary[j][i]=='W') { //방문하지 않고 Nary값이 W일때 dfs 돌고 w의 배열에 그룹의 갯수를 넣어준다.
                    dfs(j,i,'W');
                    w.add(group_cnt);
                }
                if(!visited[j][i] && Nary[j][i]=='B') {  //방문하지 않고 Nary값이 B일때 dfs 돌고 b의 배열에 그룹의 갯수를 넣어준다.
                    dfs(j,i,'B');
                    b.add(group_cnt);
                }
            }

        }
        int wcnt=0;
        int bcnt=0;
        for(int cnt:w){         //돌면서 1이 아니면 제곱의 값 
            if(cnt!=1) {
                wcnt += cnt*cnt;
            } else {
                wcnt += cnt;
            }
        }
        for(int cnt:b){
            if(cnt!=1) {
                bcnt += cnt*cnt;
            }else {
                bcnt += cnt;
            }
        }
        System.out.println(wcnt+" "+bcnt);
    }

    private static void dfs(int x, int y ,char z) {
        group_cnt++;
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x+dir[k][0];
            int ny = y+dir[k][1];
            if(nx < 0 || ny < 0 || ny >= vertical || nx >= horizontal) continue;
            if(Nary[nx][ny] != z) continue;
            if(visited[nx][ny]) continue;
            dfs(nx, ny,z);
        }
    }


    public static void main(String[] args) {
        input();
    }

}
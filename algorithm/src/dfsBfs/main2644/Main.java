package dfsBfs.main2644;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M,M2,S;
    static ArrayList<Integer>[] Nary;
    static int[] dist;


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N  = scan.nextInt();     //전체 사람 수
        M  = scan.nextInt();     // 촌수 계산번호
        M2 = scan.nextInt();     // 촌수 계산번호
        S  = scan.nextInt();     //부모 자식 관계 갯수
        Nary = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            Nary[i] = new ArrayList<Integer>();
        }
        for(int i = 1 ; i <= S ; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            Nary[x].add(y);
            Nary[y].add(x);
        }
            bfs(M);
    }
    public static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <=N ; i++){  //거리 초기화
            dist[i] = -1;
        }

        queue.add(x);
        dist[x] = 0;

        while (!queue.isEmpty()) {
            x = queue.poll();
            for(int y:Nary[x]){
                if(dist[y]!= -1){       //방문을 했다면
                    continue;
                }
                queue.add(y);
                dist[y] = dist[x] + 1;      //거리 추가
            }
        }

        System.out.println(dist[M2]);
    }

    public static void main(String[] args) {
        input();
    }

}

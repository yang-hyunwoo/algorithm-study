package dfsBfs.main5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int F,S,G,U,D;
    static boolean[] visited;
    static int[] dist;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        F = scan.nextInt(); //총 층
        S = scan.nextInt(); //현재 있는 층
        G = scan.nextInt(); //목적지 층
        U = scan.nextInt(); //위로가는 층 수
        D = scan.nextInt(); //아래로가는 층 수
        visited = new boolean[1000005];
        dist = new int[1000005];

        bfs();      //bfs 실행

        if(dist[G]==0 && S!=G) {    //현재 있는 층과 목적지가 같지 않고 거리가 0이면 접근 할수 없다.
            sb.append("use the stairs");
        } else {                    //그렇지 않으면 거리값을 출력
            sb.append(dist[G]);
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);           //현재층을 queue에 넣고 visited[]를 true로 변환
        visited[S] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();
            if(x+U <=F && !visited[x+U]) {      //x+U 값이 총층 보다 작고 visited[x+U]가 방문하지 않았다면
                visited[x+U] = true;
                dist[x+U] = dist[x]+1;
                queue.add(x + U);
            }
            if(x-D>0 && !visited[x-D]){
                visited[x-D] = true;
                dist[x-D] = dist[x]+1;
                queue.add(x-D);
            }
        }
    }


    public static void main(String[] args) {
        input();
    }

}
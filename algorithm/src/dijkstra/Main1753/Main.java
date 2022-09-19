package dijkstra.Main1753;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Edge {
        public int to , weight;

        public Edge(int to , int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info{
        public int idx , weight;

        public Info(int idx , int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N,M,start;
    static int[] dist;
    static String[] answer;
    static ArrayList<Edge>[] edges;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        start = scan.nextInt();
        dist = new int[N + 1];
        answer = new String[N+1];
        edges = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            edges[i] = new ArrayList<Edge>();
        }
        for(int i = 1 ; i <= M ; i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edges[from].add(new Edge(to, weight));
        }

        dijkstra(start);
    }

    public static void dijkstra(int start) {
        //최대 경로로 초기화
        for(int i = 1 ; i <= N ; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //최소 힙 생성
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        priorityQueue.add(new Info(start, 0));
        dist[start] = 0;

        while(!priorityQueue.isEmpty()){
            Info info = priorityQueue.poll();

            if(dist[info.idx] < info.weight) {
                continue;
            }

            //정보 갱신
            for(Edge e : edges[info.idx]) {
                if(dist[info.idx]+e.weight >= dist[e.to]) {
                    continue;
                }
                dist[e.to] = dist[info.idx] + e.weight;
                priorityQueue.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    public static void main(String[] args) {
        input();
        for(int i = 1 ; i <= N ; i++) {
            answer[i] = String.valueOf(dist[i]);
            if(dist[i]==Integer.MAX_VALUE) {
                answer[i] = "INF";
            }
            System.out.println(answer[i]);
        }
    }

}
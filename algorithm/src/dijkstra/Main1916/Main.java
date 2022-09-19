package dijkstra.Main1916;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    //그래프
    static class Edge {
        public int to ,weight;

        public Edge(int to , int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int idx , dist;

        public Info(int idx , int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N,M,start,end;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            edges[i] = new ArrayList<Edge>();
        }
        for(int i = 1 ; i <= M ; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edges[from].add(new Edge(to, weight));
        }
        start = scan.nextInt();
        end = scan.nextInt();

        dijkstra(start);
    }

    static void dijkstra(int start) {

        //정점까지의 대한 거리를 무한대로 초기화
        for(int i = 1 ; i <= N ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        //최소힙 생성
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        //시작점에 대한 정보 기록 , 거리 배열에 갱신
        priorityQueue.add(new Info(start, 0));
        dist[start] = 0;

        //거리 정보 소진될때 까지 거리 갱신 반복
        while(!priorityQueue.isEmpty()) {
            Info info = priorityQueue.poll();

            if(dist[info.idx] < info.dist) {
                continue;
            }

            //정보 갱신
            for(Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) {
                    continue;
                }
                dist[e.to] = dist[info.idx] + e.weight;
                priorityQueue.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    public static void main(String[] args) {
        input();
        System.out.print(dist[end]);
    }
}
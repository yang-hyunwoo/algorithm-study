package dijkstra.main1504;

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
    static int N,M,v1,v2;
    static ArrayList<Integer> vertex;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static StringBuilder sb = new StringBuilder();

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        vertex = new ArrayList<>();
        for(int i = 1 ; i <= N ; i++) {
            edges[i] = new ArrayList<Edge>();
        }
        for(int i = 1 ; i <= M ; i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }
            v1 = scan.nextInt();
            v2 = scan.nextInt();

            // 1 -> v1 -> v2 -> N
            int sum = 0;
                sum += dijkstra(1, v1);
                sum += dijkstra(v1, v2);
                sum += dijkstra(v2, N);

            // 1 -> v2 -> v1 -> N
            int sum2 = 0;
                sum2 += dijkstra(1, v2);
                sum2 += dijkstra(v2, v1);
                sum2 += dijkstra(v1, N);


            int ans = (sum >= 1000000000 && sum2 >= 1000000000) ? -1 : Math.min(sum, sum2);
            //음수일 경우 -1로 변환 해준다.
            if(ans <=1) {
                ans = -1;
            }

        System.out.println(ans);


    }

    public static int dijkstra(int start , int end) {

        for(int i = 1 ; i <= N ; i++) {
            dist[i] = 1000000000;
        }

        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        priorityQueue.add(new Info(start, 0));
        dist[start] = 0;

        while(!priorityQueue.isEmpty()) {
            Info info = priorityQueue.poll();

            if(dist[info.idx] < info.weight) {
                continue;
            }
            for(Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) {
                    continue;
                }
                dist[e.to] = dist[info.idx] + e.weight;
                priorityQueue.add(new Info(e.to , dist[e.to]));
            }
        }
        return dist[end];

    }


    public static void main(String[] args) {
        input();
    }

}
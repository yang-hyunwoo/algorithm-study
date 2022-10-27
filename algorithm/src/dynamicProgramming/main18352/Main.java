package dynamicProgramming.main18352;

import java.util.*;

public class Main {

    static class Edge {

        public int to , weight;

        public Edge(int to , int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int idx , dist ;

        public Info(int idx , int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N,M,K,X;
    static int[] dist;

    static ArrayList<Edge>[] edges;
    static StringBuilder sb = new StringBuilder();
    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        X = scan.nextInt();

        dist = new int[N + 1];
        edges = new ArrayList[N + 1];

        for(int i = 1 ; i <= N ; i++) {
            edges[i] = new ArrayList<Edge>();
        }

        for(int i = 1 ; i <= M ; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = 1;

            edges[from].add(new Edge(to, weight));
        }

        dijkstra(X);
        int count = 0;
        for(int i = 1 ; i <= N ;i++) {
            if(dist[i]==K) {
                sb.append(i).append("\n");
                count++;
            }
        }
        if(count==0) {
            sb.append(-1);
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        for(int i = 1 ; i <= N ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.dist));

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if(dist[info.idx] < info.dist) {
                continue;
            }
            for(Edge e:edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) {
                    continue;
                }
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to,dist[e.to]));
            }
        }
    }

    public static void main(String[] args) {
        input();
    }

}
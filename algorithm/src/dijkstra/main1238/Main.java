package dijkstra.main1238;

import java.util.*;

public class Main {

    static class Edge {
        public int to , weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int idx , weight;

        public Info(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N,M,T;

    static ArrayList<Edge>[] edges;     //정배열
    static ArrayList<Edge>[] reverse_edges; //입력 반대 배열

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        T = scan.nextInt();

        edges = new ArrayList[N+1];
        reverse_edges = new ArrayList[N + 1];

        for(int i = 1 ; i <= N ; i++) {
            edges[i] = new ArrayList<>();
            reverse_edges[i] = new ArrayList<>();
        }

        for(int i = 1 ; i<=M ; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edges[from].add(new Edge(to, weight));
            reverse_edges[to].add(new Edge(from, weight));
        }

        int[] dijkstra = dijkstra(T, edges);
        int[] dijkstra1 = dijkstra(T, reverse_edges);
        int max = 0;
        
        for(int i = 1 ; i <= N ; i++) {
            max = Math.max(max, dijkstra[i] + dijkstra1[i]);
        }
        System.out.println(max);

    }

    private static int[] dijkstra(int start, ArrayList<Edge>[] dijArray) {
        int[] dist;
        dist = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        Queue<Info> priorityQueue = new LinkedList<>();

        priorityQueue.add(new Info(start, 0));
        dist[start] = 0;

        while(!priorityQueue.isEmpty()) {
            Info info = priorityQueue.poll();
            if(dist[info.idx] < info.weight) {
                continue;
            }
            for(Edge e : dijArray[info.idx]) {
                if(dist[info.idx]+e.weight >= dist[e.to]) {
                    continue;
                }
                dist[e.to] = dist[info.idx] + e.weight;
                priorityQueue.add(new Info(e.to, dist[e.to]));
            }
        }
        return dist;
    }


    public static void main(String[] args) {
        input();
    }

}
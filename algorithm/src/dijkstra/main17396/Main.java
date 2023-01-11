package dijkstra.main17396;

import java.util.*;

public class Main {

    static class Edge {
        public long to , weight;

        public Edge(long to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public long idx , weight;

        public Info(long idx, long weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N,M;
    static long[] Nary;
    static long[] dist;
    static ArrayList<Edge>[] edges;

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new long[N+1];
        dist = new long[N+1];
        edges = new ArrayList[N+1];

        for(int i = 0 ; i < N ; i++) {
            Nary[i] = scan.nextInt();
        }

        for(int i = 0 ; i < N ; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        dijkstra(0);                            //다익스트라 실행
        int min = -1;
        System.out.println(dist[N-1]==Long.MAX_VALUE?min:dist[N-1]);


    }

    private static void dijkstra(int start) {
        boolean[] visited = new boolean[N];
        for(int i = 0 ; i < N ; i++) {          //거리 MAX 초기화
            dist[i] = Long.MAX_VALUE;
        }

        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(o-> (int) o.weight));       //우선순위 큐

        queue.add(new Info(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            if(visited[(int) info.idx]) continue;
            visited[(int) info.idx] = true;

            if(info.idx==N-1) continue;
            if(dist[(int) info.idx]<info.weight || Nary[(int) info.idx]==1) continue;
                for(Edge e : edges[(int) info.idx]) {
                    if(dist[(int) info.idx] + e.weight > dist[(int) e.to]) {
                        continue;
                    }
                    dist[(int) e.to] = dist[(int) info.idx]+e.weight;
                    queue.add(new Info(e.to, dist[(int) e.to]));

                }
            }
        }

    public static void main(String[] args) {
        input();
    }

}
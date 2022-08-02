package dfsBfs.main2251;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class State{
    int[] X;
    State(int[] _X){
        X = new int[3];
        for (int i=0;i<3;i++) X[i] = _X[i];
    }

    State move(int from,int to,int[] Limit){
        int[] nX = new int[]{X[0], X[1], X[2]};
        if (X[from] + X[to] <= Limit[to]){
            nX[to] = nX[from] + nX[to];
            nX[from] = 0;
        }else{
            nX[from] -= Limit[to] - nX[to];
            nX[to] = Limit[to];
        }
        return new State(nX);
    }
};

public class Main {

    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        Limit = new int[3];
        for(int i = 0 ; i < 3 ; i++){
            Limit[i] = scan.nextInt();
        }
        visit = new boolean[205][205][205];
        possible = new boolean[205];

    }

    static void pro() {
        bfs(0,0,Limit[2]);
        for(int i = 0 ; i <= 200; i++){
            if(possible[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
    // 물통 탐색 시작~
    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        Q.add(new State(new int[]{x1, x2, x3}));

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    // i 번 물통에서 j 번 물통으로 물을 옮긴다.
                    State nxt = st.move(from, to, Limit);

                    // 만약 바뀐 상태를 탐색한 적이 없다면
                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}

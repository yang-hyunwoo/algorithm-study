package bruteForce.main18429;

import java.util.Scanner;

public class Main {

    static int N,M  , count = 0;
    static int[] weight;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        weight = new int[N];
        visited = new boolean[N];
        for(int i = 0 ; i < N ; i++) {
            weight[i] = scan.nextInt();
        }
        dfs(500,0);
        System.out.println(count);
    }

    public static void dfs(int sum , int cnt) {
        if(cnt==N) {
            count++;
            return ;
        }
        for(int i = 0 ; i < N; i++) {
            if(!visited[i] && sum+weight[i]-M >=500) {
                visited[i] = true;
                dfs(sum + weight[i] - M, cnt + 1);
                visited[i] = false;
            }
        }
    }




    public static void main(String[] args) {
        input();
    }

}

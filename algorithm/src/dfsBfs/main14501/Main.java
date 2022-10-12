package dfsBfs.main14501;

import java.util.Scanner;

public class Main {

    static int N,result;
    static int[][] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N][2];
        for(int i = 0; i < N ; i++) {
            Nary[i][0] = scan.nextInt();
            Nary[i][1] = scan.nextInt();
        }
        result = 0;

        dfs(0,0);
        System.out.println(result);
    }

    public static void dfs(int idx , int pay) {
        if(idx >=N) {
            result = Math.max(result,pay);
            return;
        }
        if(idx+Nary[idx][0] <= N){
            dfs(idx+Nary[idx][0] , pay+Nary[idx][1]);
        } else {
            dfs(idx+Nary[idx][0],pay);
        }
        dfs(idx+1,pay);

    }


    public static void main(String[] args) {
        input();
    }

}
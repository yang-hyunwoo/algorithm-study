package tree.main1068;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N,M,root;
    static ArrayList<Integer>[] child;
    static int[] parent;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        child = new ArrayList[N];
        parent = new int[N];
        for(int i = 0 ; i < N ; i++){
            child[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < N ; i++){
            int x = scan.nextInt();
            if(x == -1){
                root = i;
                continue;
            } else {
                child[x].add(i);
            }
        }

        M = scan.nextInt();
        pro();
    }

    public static void pro() {
        for(int i = 0 ; i < N ; i++){
            if(child[i].contains(M)) {
                child[i].remove(child[i].indexOf(M));
            }
        }

        if(root != M) {
            dfs(root);
        }

        System.out.println(parent[root]);

    }
    public static void dfs(int x) {

        if(child[x].isEmpty()){
            parent[x] = 1;
        }

        for(int y : child[x]){
            dfs(y);
            parent[x] += parent[y];
        }

    }

    public static void main(String[] args) {
        input();
    }

}

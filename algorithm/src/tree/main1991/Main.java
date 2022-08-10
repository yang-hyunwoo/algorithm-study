package tree.main1991;

import java.util.Scanner;

public class Main {

    static int n;

    static int[][] childs;

    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    static void input() {
        n = scan.nextInt();
        childs = new int[30][2];
        for (int i = 0; i < n; i++) {
            char curCh = scan.next().charAt(0);
            int cur = (int)(curCh - 'A');
            for (int k = 0; k < 2; k++) {
                char ch = scan.next().charAt(0);
                if (ch != '.') childs[cur][k] = (int)(ch - 'A');
                else childs[cur][k] = -1;
            }
        }
    }
    static void in_order(int x) {
        if (x == -1) return;
        in_order(childs[x][0]);
        sb.append((char)(x + 'A'));
        in_order(childs[x][1]);
    }

    static void pre_order(int x) {
        if (x == -1) return;
        sb.append((char)(x + 'A'));
        pre_order(childs[x][0]);
        pre_order(childs[x][1]);
    }

    static void post_order(int x) {
        if (x == -1) return;
        post_order(childs[x][0]);
        post_order(childs[x][1]);
        sb.append((char)(x + 'A'));
    }
    static void pro() {
        pre_order(0);
        sb.append('\n');
        in_order(0);
        sb.append('\n');
        post_order(0);

        // 정답 출력하기
        System.out.print(sb);
    }
    public static void main(String[] args) {
        input();
        pro();
    }

}

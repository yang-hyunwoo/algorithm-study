package twoPointer.main13144;

import java.io.*;
import java.util.StringTokenizer;

public class Main {  //다시 풀기 .....
    static readers scan = new readers();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A, cnt;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        cnt = new int[100000 + 1];
    }

    static void pro() {
        long ans = 0;

        for (int L=1, R=0; L<=N; L++){  // L 마다 R 을 최대한 옮겨 줄 계획이다.
            // R 을 옮길 수 있는 만큼 옮긴다.
            while (R + 1 <= N && cnt[A[R+1]] == 0){
                R++;
                cnt[A[R]]++;
            }

            // 정답을 갱신한다
            ans += R - L + 1;

            // L 을 옮겨주면서 A[L] 의 개수를 감소시킨다.
            cnt[A[L]]--;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class readers {
        BufferedReader br;
        StringTokenizer st;

        public readers() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public readers(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
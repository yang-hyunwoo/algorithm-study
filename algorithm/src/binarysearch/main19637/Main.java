package binarysearch.main19637;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] ching = new String[N];
        int[] damage = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ching[i] = st.nextToken();
            damage[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int l = 0, r = N - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (damage[mid] < input) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            bw.write(ching[l] + "\n");
        }
        bw.flush();
    }
}
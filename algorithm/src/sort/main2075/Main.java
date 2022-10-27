package sort.main2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N*N];

        int idx =0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        sort();
    }

    public static void sort() {
            Arrays.sort(arr);
            System.out.println(arr[arr.length-N]);
    }


    public static void main(String[] args) throws IOException {
        input();
    }

}

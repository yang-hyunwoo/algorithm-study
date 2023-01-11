package twoPointer.main3151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        Nary = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Nary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Nary);

        two_pointer();
    }

    public static void two_pointer() {
        long count = 0L;
        for(int i = 0 ; i <N; i++){
            int L = i + 1, R = N - 1;
            if(Nary[i]>0){
                break;
            }
            while(L <R) {
                int a = 1;
                int b = 1;
                int cur = Nary[i] + Nary[L] + Nary[R];
                if(cur == 0 ){
                    if(Nary[L]==Nary[R]) {
                        count += (R-L+1) * (R-L+1 - 1) / 2;
                        break;
                    }
                    while(L+1 < R && Nary[L]==Nary[L+1]) {
                        a++;
                        L++;
                    }
                    while (L<R-1 && Nary[R]==Nary[R-1]) {
                        b++;
                        R--;
                    }
                    count += a*b;
                }
                if(cur >0) {
                    R--;
                }else {
                    L++;
                }
            }

        }
        System.out.println(count);
    }


    public static void main(String[] args) throws IOException {
        input();
    }

}
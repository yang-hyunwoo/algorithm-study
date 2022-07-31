package sort.main5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static String[] Nary;

      static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void input() throws IOException {
        M = Integer.parseInt(br.readLine());
        Nary = new String[M+1];
        for(int i = 1 ; i <= M ; i++) {
            Nary[i] = br.readLine();
        }

    }

    public static void sort() {
        Arrays.sort(Nary,1,M+1);
        if (chk(M, Nary)) {
            sb.append("YES").append("\n");
        } else {
            sb.append("NO").append("\n");
        }
    }

    public static boolean chk(int X , String[] A){
        for(int i= 1 ; i < X ; i++){
            if(Nary[i+1].startsWith(Nary[i])){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int i = 0;
        while( i< N) {
            input();
            sort();
            i++;
        }
        System.out.println(sb.toString());
    }


}
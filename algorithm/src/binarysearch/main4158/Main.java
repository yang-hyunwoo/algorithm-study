package binarysearch.main4158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] SangAry;
    static int[] SunAry;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean binarySearch(int[] A , int L , int R , int X) {
        int mid = 0;
        while(L<=R) {
            mid = (L+R)/2;
            if(A[mid]==X){
                return true;
            } else if(A[mid]>X){
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M ==0) {
                return;
            }
            SangAry = new int[N];
            SunAry = new int[M];
            for(int i = 0 ; i < N ; i++) {
                SangAry[i] = Integer.parseInt(br.readLine());
            }
            for(int i = 0 ; i < M ; i++) {
                SunAry[i] = Integer.parseInt(br.readLine());
            }
            int count = 0;
            for(int i = 0 ; i < N ; i++) {
                if(binarySearch(SunAry,0,M,SangAry[i])){
                    count++;
                }
            }
            System.out.println(count);
        }

    }

}
package binarysearch.main1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] Nary , Mary ;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            Nary[i] = scan.nextInt();
        }
        M = scan.nextInt();
        Mary = new int[M+1];
        for(int i = 1 ; i<= M ; i++) {
            Mary[i] = scan.nextInt();
        }
    }

    static void sort() {
        Arrays.sort(Nary , 1 , N+1);

        for(int i = 1 ; i <= M ; i++) {
            if(binary_search(Nary,1,N , Mary[i])){
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static boolean binary_search(int[] A , int L , int R , int X){
        while(L <= R) {
            int mid = (L+R) / 2;
            if(A[mid]==X){
                return true;
            } else if(A[mid] > X){
                R = mid -1;
            } else {
                L = mid + 1;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        input();
        sort();
    }

}
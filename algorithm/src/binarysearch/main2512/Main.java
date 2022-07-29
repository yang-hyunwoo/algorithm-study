package binarysearch.main2512;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M,sum;
    static int[] Nary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N+1];

        for(int i = 1 ; i <= N ; i ++) {
            Nary[i] = scan.nextInt();
            sum += Nary[i];
        }

        M = scan.nextInt();

        sort();
    }

    public static void sort() {
        int max =0;
        Arrays.sort(Nary,1,N+1);
        long L  = 1 , R = Integer.MAX_VALUE , ans = 0;
        if(sum > M ){
            while(L <= R){
                long mid = (L+R)/2;
                if(chk((int)mid)){
                    L = mid + 1;
                    max = (int)mid;
                } else {
                    R = mid - 1;
                }
            }
            sb.append(max);
        } else{
            sb.append(Nary[N]);
        }
    }

    static boolean chk(int A){
        long sum = 0;
        for(int i = 1 ; i < N+1; i++){
            if(Nary[i] <= A){
                sum += Nary[i];
            } else {
                sum += A;
            }
        }
        return  M >= sum ;
    }


    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());

    }

}

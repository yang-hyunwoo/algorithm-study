package binarysearch.main16401;

import java.util.Scanner;

public class Main {

    static int N,M;
    static long max = 0;
    static int[] Mary;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Mary = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            Mary[i] = scan.nextInt();
        }

        binary_search();
    }

    public static void binary_search() {
        long L = 1 , R = 1000000000 ;           //최대 10억으로 초기 세팅
        while(L <=R) {
            long mid = (L+R)/2;
            if(chk(mid)) {                      //chk 메소드 호출
                max = Math.max(max , mid);      //max 값과 mid 값을 비교 후 큰 값을 max 로 변환
                L = mid+1;
            } else {
                R = mid-1;
            }
        }
        System.out.println(max);
    }

    public static boolean chk(long a) {         //mid 의 값을 받아 온 후 과자의 배열을 순차적으로 반복을 하면서 과자의 몫을 sum에 더 한 후 N의 값을 비교를 하고 true / false를 반환 해준다.
        long sum = 0 ;
        for(int i = 1 ; i <=M; i++) {
             sum +=Mary[i]/a ;
        }
        return sum >= N;
    }


    public static void main(String[] args) {
        input();
    }

}
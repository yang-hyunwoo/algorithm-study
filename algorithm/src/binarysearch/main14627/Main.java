package binarysearch.main14627;

import java.util.Scanner;


public class Main {

    static long greenOninon;
    static long chicken;
    static long[] greenOnionAry;


    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        greenOninon = scan.nextInt();
        chicken = scan.nextInt();
        greenOnionAry = new long[(int) greenOninon];
        for (int i = 0; i < greenOninon; i++) {
            greenOnionAry[i] = scan.nextInt();
        }

        binarySearch();
    }

    public static void binarySearch() {
        long L =0 , R = 1000000000 , ramen=0;
        while(L <=R) {
            long mid = (L+R)/2;
            if(chk(mid)) {
                ramen = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
       ans(ramen);
    }

    public static boolean chk(long mid) {
        int cnt = 0 ;
        for(int i = 0 ; i < greenOninon ; i++) {
            if(mid!=0) {
                cnt += greenOnionAry[i] / mid;
            }
        }
        return cnt >= chicken;

    }

    public static void ans(long ramen) {
        long ramenOnion=0;
        int cnt = 0;
        for(int i = 0 ; i < greenOninon ; i++) {
            if (ramen != 0) {
                cnt += greenOnionAry[i] / ramen;
                ramenOnion += greenOnionAry[i] % ramen;
                if (cnt > chicken) {
                    ramenOnion += (cnt - chicken) * ramen;
                    cnt -= cnt - chicken;
                }
            }
        }
        System.out.println(ramenOnion);
    }


    public static void main(String[] args) {
        input();
    }

}
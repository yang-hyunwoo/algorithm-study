package binarysearch.main2792;

import java.util.Scanner;

public class Main {

    static int child , color,R = Integer.MIN_VALUE;
    static int[] colorAry;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        child = scan.nextInt();
        color = scan.nextInt();
        colorAry = new int[color+1];

        for(int i = 0 ; i < color ; i++) {
            colorAry[i] = scan.nextInt();
            R = Math.max(R,colorAry[i]);
        }

        binarySearch();
    }

    private static void binarySearch() {
        int L =1  ,ans = 0;

        while (L <= R) {
            int mid = (L+R)/2;
            int sum =0;
            for(int i = 0 ; i < color ; i++) {
                if(colorAry[i]%mid ==0) {
                    sum += colorAry[i]/mid;
                } else {
                    sum += colorAry[i]/mid +1;
                }
            }
            if(sum > child) {
                L = mid+1;
            } else {
                R = mid -1;
                ans = mid;
            }
        }
        System.out.println(ans);

    }

    public static void main(String[] args) {
        input();
    }

}
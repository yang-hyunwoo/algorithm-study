package sort.main5576;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    static StringBuilder sb = new StringBuilder();
    static Integer[] W;
    static Integer[] K;

    public static void input() {
        Scanner scan = new Scanner(System.in);

        W =new Integer[10];
        K =new Integer[10];

        for(int i = 0 ; i <10 ; i++){
            W[i] = scan.nextInt();
        }
        for(int i = 0 ; i <10 ; i++){
            K[i] = scan.nextInt();
        }

        Arrays.sort(W, Collections.reverseOrder());
        Arrays.sort(K, Collections.reverseOrder());

        int sum = W[0] + W[1] + W[2];
        int sum2 =K[0] + K[1] + K[2];

        System.out.println(sum+" "+sum2);
    }


    public static void main(String[] args) {
        input();
    }

}
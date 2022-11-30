package bruteForce.main1145;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        input();
    }

    public static void input() {
        num = new int[5];
        for (int i = 0; i < 5; i++) {
            num[i] = scan.nextInt();
        }
        int val = 1;
        int count = 0;

        while(true) {
            for(int k = 0 ; k < 5; k++) {
                if(val%num[k] ==0) {
                    count++;
                }
            }
            if(count >= 3) {
                System.out.println(val);
                return;
            }
            count=0;
            val++;
        }
    }

}

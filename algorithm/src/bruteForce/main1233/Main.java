package bruteForce.main1233;


import java.util.Scanner;


public class Main {

    static int S1,S2,S3;
    static Integer[] ary;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        S1 = scan.nextInt();
        S2 = scan.nextInt();
        S3 = scan.nextInt();
        ary = new Integer[(S1 + S2 + S3)+1];

        for(int i = 0 ; i<ary.length;i++){
            ary[i] = 0;
        }
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    ary[i + j + k]++;
                }
            }
        }

        int key = 0;
        int ans = 0;
        for(int i = 0 ; i < ary.length;i++){
            key = Math.max(key, ary[i]);
        }
        for(int i = 0 ; i <= ary.length;i++){
            if(key == ary[i]) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        input();
    }

}
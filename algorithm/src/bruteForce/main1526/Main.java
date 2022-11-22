package bruteForce.main1526;

import java.util.Scanner;

public class Main {

    static int N;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int max = 0;
        for(int i = 4; i <=N;i++) {
            String a = String.valueOf(i);

            String a1 = a.replace("4","");
            String a2 = a1.replace("7","");

            if(a2.isEmpty()){
                max = Integer.valueOf(a);
            }
        }

        System.out.println(max);
    }


    public static void main(String[] args) {
        input();
    }

}
package greedy.main1789;

import java.util.Scanner;

public class Main {

    static String N;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextLine();
        long a = Long.parseLong(N);
        long sum = 0;
        long max = 0;
        for(long i = 1 ; i <=a; i++){
            if(sum<=a){
                sum+=i;
                max = Math.max(max,i);
            }
        }
        if(sum==a){
            System.out.println(max);
        }else {
            System.out.println(max-1);

        }
    }


    public static void main(String[] args) {
        input();
    }

}
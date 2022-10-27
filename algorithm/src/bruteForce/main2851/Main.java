package bruteForce.main2851;

import java.util.Scanner;

public class Main {

    static int[] Nary;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        Nary = new int[10];
        for(int i = 0 ; i < 10 ; i++) {
            Nary[i] = scan.nextInt();
        }

        int sum = 0;
        int min = 0;
        for(int i = 0 ; i < 10 ; i++) {
            sum += Nary[i];
            if(sum>100) {
                int a = Math.abs(100-sum);
                 sum -= Nary[i];
                int b = Math.abs(100-sum);
                if(b>=a){
                    min = sum+=Nary[i];
                } else {
                    min = sum;
                }
                break;
            } else {
                min = sum;
            }
        }

        System.out.println(min);
    }


    public static void main(String[] args) {
        input();
    }

}
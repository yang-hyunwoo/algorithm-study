package bruteForce.main1057;


import java.util.Scanner;

public class Main {

    static int N,M,S;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        S = scan.nextInt();


        while(M!=S){
            M = (M/2)+(M%2);
            S = (S/2)+(S%2);
            count++;
        }

        System.out.println(count);
    }


    public static void main(String[] args) {
        input();
    }

}
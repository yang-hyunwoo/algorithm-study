package bruteForce.main14697;

import java.util.Scanner;

public class Main {

    static int N,M,S,ANS,total=0;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        S = scan.nextInt();
        ANS = scan.nextInt();

        for(int i = 0 ; i<= 50 ; i++) {
            for(int j = 0 ; j <=50 ;j++){
                for(int k = 0 ; k <= 50 ; k++) {
                    if((N*i) + (M*j) + (S*k)==ANS){
                        total = 1;
                    }
                }
            }
        }
        System.out.println(total);
    }


    public static void main(String[] args) {
        input();
    }

}

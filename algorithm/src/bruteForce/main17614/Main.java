package bruteForce.main17614;

import java.util.Scanner;


public class Main {

    static int N,M;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        bruteForce();
    }

    private static void bruteForce() {
        int count = 0;
        for(int i = 1 ; i <= N ; i++){
            if(String.valueOf(i).contains("3")) {
                int iLength = String.valueOf(i).length();
                String replaceLength = String.valueOf(i).replace("3","");
                count += iLength - replaceLength.length();
            }
            if(String.valueOf(i).contains("6")) {
                int iLength = String.valueOf(i).length();
                String replaceLength = String.valueOf(i).replace("6","");
                count += iLength - replaceLength.length();
            }
            if(String.valueOf(i).contains("9")) {
                int iLength = String.valueOf(i).length();
                String replaceLength = String.valueOf(i).replace("9","");
                count += iLength - replaceLength.length();
            }
        }
        System.out.println(count);

    }


    public static void main(String[] args) {
        input();
    }

}
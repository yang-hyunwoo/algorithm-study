package bruteForce.main1439;

import java.util.Scanner;

public class Main {

    static String N;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextLine();
        int countZero = 0;
        int countOne = 0;
        char start =N.charAt(0);
        if(start=='0') {
            countZero++;
        } else {
            countOne++;
        }
        for(int i = 0 ; i<N.length();i++) {
            if(start!=N.charAt(i)) {
                start = N.charAt(i);
                if(start=='0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
        }
        int min = Math.min(countOne, countZero);
        System.out.println(min);

    }


    public static void main(String[] args) {
        input();
    }

}

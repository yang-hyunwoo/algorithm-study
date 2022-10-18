package other.main10953;

import java.util.Scanner;

public class Main {

    static int N;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        for(int i = 0 ; i < N ; i++) {
            String a = scan.nextLine();
            String[] b = a.split(",");

            int sum = Integer.parseInt(b[0]) + Integer.parseInt(b[1]);
            System.out.println(sum);

        }

    }


    public static void main(String[] args) {
        input();
    }

}
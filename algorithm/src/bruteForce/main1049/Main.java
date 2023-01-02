package bruteForce.main1049;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        int Min = Integer.MAX_VALUE;

        int[] pack = new int[M];
        int[] unit = new int[M];
        for(int i=0; i<M; i++){
            pack[i] = scan.nextInt();
            unit[i] = scan.nextInt();
        }
        Arrays.sort(unit);
        Arrays.sort(pack);

        Min = Math.min(((N/6)+1)*pack[0], N*unit[0]);
        Min = Math.min(Min, ((N/6))*pack[0] + (N%6)*unit[0]);

        System.out.println(Min);
    }


    public static void main(String[] args) {
        input();
    }

}
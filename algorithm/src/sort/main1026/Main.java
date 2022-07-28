package sort.main1026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int CNT;
    static int[] Aary , Bary;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        CNT = scan.nextInt();
        Aary = new int[CNT+1];
        Bary = new int[CNT+1];
        visited = new boolean[CNT+1];

        for(int i = 1 ; i <= CNT ; i++){
            Aary[i] = scan.nextInt();
        }

        for(int i = 1 ; i <= CNT ; i++){
            Bary[i] = scan.nextInt();
        }

    }

    static void sort() {
        int avg ;
        int sum = 0;
        int change=0 ;
        int min ;
        Arrays.sort(Aary,1,CNT+1);
        for(int i = 1 ; i <=CNT ; i++){
            avg = 0;
            min = Integer.MIN_VALUE;
            for(int j=1; j<=CNT; j++){
                if(Aary[i]==0){
                    if (!visited[j]) {
                        if (avg <= Bary[j]) {
                            avg = Bary[j];
                            change = j;
                        }
                    }
                } else {
                    if (!visited[j]) {
                        if(min <= Bary[j]) {
                            min = Bary[j];
                            avg = Bary[j];
                            change = j;
                        }
                    }
                }
            }
            visited[change] = true;
            sum+= Aary[i]*avg;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        input();
        sort();
    }

}
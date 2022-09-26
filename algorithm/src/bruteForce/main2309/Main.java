package bruteForce.main2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] Nary ;
    static int[] selected;
    static int sum =0;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        Nary = new int[10];
        selected = new int[3];
        for(int i = 1 ; i <=9; i++){
            Nary[i] = scan.nextInt();
            sum +=Nary[i];
        }
    }

    static void sort() {
        int total;
        Arrays.sort(Nary,1,10);
        total = sum-100;
        rec_func(1,total);
    }

    static void rec_func(int k,int total){
        int sum = 0;
        int count = 0;
        if(k==3){
            for (int i = 1; i < 3; i++) {
                sum +=selected[i];
            }
            if(sum==total){
                sb.setLength(0);
                for (int i = 1; i < 10; i++) {
                    if (Nary[i] != selected[1] && Nary[i] != selected[2]) {
                        sb.append(Nary[i]).append(" ");
                    }
                }
            }
            sb.append("\n");
        } else {
            for(int cand = 1 ; cand<10; cand++){
                boolean isUsed = false;
                for(int i = 1 ; i < k ; i++){
                    if(selected[i] == Nary[cand]){
                        isUsed = true;
                    }
                }
                if(!isUsed){
                    selected[k] = Nary[cand];
                    rec_func(k+1,total);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }

}
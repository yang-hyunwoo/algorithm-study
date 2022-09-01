package sort.main1302;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,count,max;
    static String maxValue,curValue;
    static String[] Nary;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        Nary = new String[N+1];
        for(int i = 1 ; i <= N ; i++ ){
            Nary[i] = scan.nextLine();
        }
        sort();
    }

    public static void sort() {
        Arrays.sort(Nary,1,N+1);
        count = 1;
        max = 1;
        maxValue = Nary[1];
        curValue = Nary[1];
        for(int i = 2 ; i <= N ; i++ ){
            if(curValue.equals(Nary[i])){
                count++;
                if(max < count){
                    maxValue = curValue;
                    max = count;
                }
            } else {

                count = 1;
                curValue = Nary[i];
            }
        }
        System.out.println(maxValue);
    }


    public static void main(String[] args) {
        input();
    }

}
package binarysearch.main11053;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] Nary;

    static Integer[] point;



    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N];
        point = new Integer[N];
        for(int i = 0 ; i < N ; i++){
            Nary[i] = scan.nextInt();
        }
        for(int i = 0 ;  i < N ;  i++){
            Lis(i);
        }
        int max = point[0];
        for(int i = 0; i < N; i++) {
            max = Math.max(max, point[i]);
        }
        System.out.println(max);
    }



    public static int Lis(int A){

        if(point[A]== null){
            point[A] = 1;

            for(int i= A-1 ; i>=0 ; i--){
                if(Nary[i] < Nary[A]){
                    point[A] = Math.max(point[A], Lis(i) + 1);
                }
            }
        }
        return point[A];
    }

    public static void main(String[] args) {
        input();
    }

}
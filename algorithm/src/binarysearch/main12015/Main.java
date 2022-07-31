package binarysearch.main12015;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] Nary , Lis;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N];
        Lis = new int[N];
        for(int i = 0 ; i < N ; i++){
            Nary[i] = scan.nextInt();
        }
    }

    public static void lis() {
        Lis[0] = Nary[0];
        int length = 1;

        for(int i = 0; i < N ; i++){
            int key = Nary[i];

            if(Lis[length - 1] < key){
                length++;
                Lis[length -1] = key;
            } else {
                int L =0;
                int R = length;

                while(L < R){
                    int mid = (L+R)/2;
                    if(Lis[mid]< key){
                        L = mid+1;
                    } else {
                        R = mid ;
                    }
                }
                Lis[L] = key;
            }
        }
        System.out.println(length);
    }


    public static void main(String[] args) {
        input();
        lis();
    }

}
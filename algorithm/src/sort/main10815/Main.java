package sort.main10815;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int A,B;
    static int[] Aary , Bary ;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        Aary = new int[A+1];

        for(int i = 1 ; i <= A; i++){
            Aary[i] = scan.nextInt();
        }
        B = scan.nextInt();
        Bary = new int[B+1];

        for(int i = 1 ; i <= B; i++){
            Bary[i] = scan.nextInt();
        }

    }

    static void sort() {
        Arrays.sort(Aary,1,A+1);
        for(int i = 1 ; i <=B ; i++) {
            int a = binary_search(Aary , 1 , A , Bary[i]);
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString());
    }
    static int binary_search(int[] A , int L , int R , int X) {
        while(L <= R) {
            int mid = (L+R)/2;
            if(A[mid]==X){
                return 1;
            } else if(A[mid]>X){
                R = mid-1;
            } else {
                L = mid +1;
            }

        }
        return 0;
    }


    public static void main(String[] args) {
        input();
        sort();
    }

}
package binarysearch.main2776;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M,S;
    static int[] one , two;

    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);


    public static void input() {
        M = scan.nextInt();
        one = new int[M + 1];

        for(int i = 1; i <= M ; i++) {
            one[i] = scan.nextInt();
        }

        S = scan.nextInt();
        two = new int[S + 1];

        for(int i = 1; i <= S ; i++) {
            two[i] = scan.nextInt();
        }

        Arrays.sort(one , 1 , M+1);                                    //one의 배열을 정렬을 해준다.

        for(int i = 1; i <= S; i++) {
            sb.append(binary_search(one , 1 , M , two[i])).append("\n");            // binary_search를 이용한다.
        }
    }

    public static int binary_search(int[] A , int L , int R , int x) {
        while(L <=R) {                          //R 이 L보다 클때까지 반복한다.
            int mid = (L+R)/2;                  //중앙을 찾는다.
            if(A[mid]==x) {                     //만약 중앙을 찍은 값과 x의 값이 일치 하다면 two[i]의 값이 one 배열에 있다는 것을 의마한다.
                return 1;                       //있다면 1을 리턴한다.
            } else if(A[mid] > x) {             //A[mid]가 더 크다면 전의 미드 에서 끝까지 값이 필요 없기 때문에 R 을 mid-1 로 옮겨 준다.
                R = mid - 1;
            } else if(A[mid] < x) {             //A[mid]가 더 작다면 처음부터 미드 까지의 값이 필요 없기 때문에 L 을 mid+1로 옮겨 준다.
                L = mid +1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        N = scan.nextInt();

        for(int i = 1 ; i <= N ; i++) {
            input();
        }
            System.out.println(sb.toString());
    }
}
package twoPointer.main13422;

import java.util.Scanner;

public class Main {

    static int N,M,S,K;
    static int[] Mary;

    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);


    public static void input() {
        M = scan.nextInt();         //마을 갯수
        S = scan.nextInt();         //연속 도둑이 들 갯수
        K = scan.nextInt();         //돈의 제한값

        Mary = new int[M];

        for(int i = 0 ; i < M ; i++) {
            Mary[i] = scan.nextInt();
        }

        two_pointer();
    }

    public static void two_pointer() {
        int R = 0;
        long sum = 0;
        int count = 0;
        if(M==S) {                                  // 마을 갯수와 도둑이 털 갯수가 같으면
            for(int i = 0 ; i < M ; i++){           // 모든 마을 갯수 돈을 더하고 리턴 한다.
                sum +=Mary[i];
            }
            if(sum < K) {
                count++;
            }
        }else {
        for(int i = 0 ; i < M ; i++) {              //마을 갯수와 도둑이 털 갯수가 같지 않다면
            if (i != 0) {
                sum -= Mary[i - 1];
            }
            while ((R - i) != S) {                  //도둑이 털 갯수가 맞을 때까지 반복한다.
                if (R < M) {                        //문제 지문에서 마지막 배열이 첫번째과 이어져 있다고 가정을 하기 때문에 마지막 후 값은 첫번째 배열의 값을 주기 위해
                    sum += Mary[R];
                } else {
                    sum += Mary[R - M];
                }
                R++;
            }
            if (sum < K) {                          //도둑이 훔친돈이 방범을 뚫었을 경우 갯수 증가
                count++;
            }
        }
        }
        sb.append(count).append("\n");

    }


    public static void main(String[] args) {
        N = scan.nextInt();
        for(int i = 0 ; i < N ; i++) {
            input();
        }
        System.out.println(sb.toString());
    }

}

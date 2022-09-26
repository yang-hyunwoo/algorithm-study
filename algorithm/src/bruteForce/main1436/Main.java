package bruteForce.main1436;

import java.util.Scanner;
public class Main {
    static int N;
    static int Count;
    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
    }
    static void rec_func() {

        for(int i=0;i<Integer.MAX_VALUE;i++) {              //int 맥스 값까지 돌린다.
            if(Integer.toString(i).contains("666")) {       //만약 666이 있다면 count를 증가 시킨다.
                Count++;
            }
            if(N==Count) {                                  //N과 Count가 같을 경우
                System.out.println(i);
                break;
            }
        }

    }

    public static void main(String[] args) {
        input();
        rec_func();
    }

}
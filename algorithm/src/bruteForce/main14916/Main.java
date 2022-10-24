package bruteForce.main14916;

import java.util.Scanner;

public class Main {

    static int N,count=0;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        System.out.println(rec());
    }

    public static int rec() {
        if(N==1 || N==3) {  //N이 1 이나 3일 경우는 나눌수가 없으므로
            return -1;
        }
        if(N%5==0) {        //5로 나누어 떨어질경우
           return count = N/5;
        }
        int b = N%5;        //5를 나눈 나머지
        if(b%2==0){        //5를 나눈 나머지가 2로 나누어 진다면
            count += N/5;
            count += b/2;
            return count ;
        } else {
            count += N/5;       //갯수를 5로 나눈 몫을 COUNT 저장
            count--;            //5를 1개 뺌
            b+=5;
            count += b/2;       //나머지+5에 2를 나눈 몫
            return count;
        }
    }


    public static void main(String[] args) {
        input();
    }

}
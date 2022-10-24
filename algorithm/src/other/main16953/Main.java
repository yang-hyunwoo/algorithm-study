package other.main16953;

import java.util.Scanner;

public class Main {

   static int N , M ;


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();


        rec();
    }

    public static void rec() {
        int count = 0 ;
        while(true) {
            if(M <= N) {            //N 이 M 보다 클 경우 WHILE 문을 벗어난다.
                break;
            }
            if(String.valueOf(M).endsWith("1")) {           //만약 M이 1로 끝나는 경우는 1을 추가 한경우이므로 M에서 1을 빼주고 COUNT 증가
                int Mlength = String.valueOf(M).length();
                String value = String.valueOf(M).substring(0,Mlength-1);
                M = Integer.valueOf(value);
                count++;
            } else {                                        //그렇지 않을 경우 M나머지가 0 인경우 M을 2로 나누고 COUNT 증가
                if(M%2==0) {
                    M = M / 2;
                    count++;
                } else {
                    break;
                }
            }

        }
        if(M==N) {
            System.out.println(count+1);
        } else {
            System.out.println("-1");
        }
    }


    public static void main(String[] args) {
        input();
    }

}
package sort.main10610;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static String N;
    static Integer[] Nary;

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextLine();
        Nary = new Integer[N.length()];

        for (int i = 0; i < N.length(); i++) {
            Nary[i] = Character.getNumericValue(N.charAt(i));
        }

        Arrays.sort(Nary,Collections.reverseOrder());           //역순으로 정렬

        long a =0;

        for (int i = 0; i < N.length(); i++) {
            a +=Long.parseLong(String.valueOf(Nary[i]));        //N의 값을 모두 더한다.
        }

        if(!N.contains("0") || a % 3 !=0) {                     //N에 0이 없다면 30의 배수가 되지 않고 3으로 나누어 떨어지지 않으면 30의 배수가 아니기 때문에
            System.out.println("-1");
        } else {
            for (int i = 0; i < N.length(); i++) {
                System.out.print(Nary[i]);
            }

        }

    }


    public static void main(String[] args) {
        input();
    }

}
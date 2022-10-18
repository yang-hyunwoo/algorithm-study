package sort.main1431;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class Elem implements Comparable<Elem> {
        String a;                                                   //오래 걸린점
                                                                    //여기에 int sum을 하고 sum , o.sum을 만들어서 sum을 증가시키고 비교 했더니 백준에서 3%에서 계속 틀렸음...
        @Override
        public int compareTo(Elem o) {
            int sum = 0;
            int sum1 =0;
            if(a.length()==o.a.length()) {                              //길이가 같다면
                for(int i = 0 ; i <a.length();i++) {                    //반목을 통해서 값이 숫자인지 파악하기
                    if(Character.isDigit(a.charAt(i))) {
                            sum += Integer.parseInt(String.valueOf(a.charAt(i)));           //숫자이면 sum을 증가
                    }
                    if(Character.isDigit(o.a.charAt(i))) {
                        sum1 +=  Integer.parseInt(String.valueOf(o.a.charAt(i)));
                    }
                }
                if(sum==sum1) {                                         //sum이 같다면 사전순으로 정렬
                    return a.compareTo(o.a);
                } else {
                    return sum - sum1;
                }
            }else {                                                    //길이가 다르면 길이 순으로 정렬
                return a.length()-o.a.length();
            }
        }
    }
    static int N;
    static Elem[] Nary;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new Elem[N];
        scan.nextLine();

        for(int i = 0 ; i < N ; i++){
            Nary[i] = new Elem();
            Nary[i].a = scan.nextLine();
        }


        Arrays.sort(Nary,0,N);

        for(int i = 0 ; i < N ; i++){
            System.out.println(Nary[i].a);
        }
    }


    public static void main(String[] args) {
        input();
    }

}
package bruteForce.main1977;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N,M;
    static ArrayList<Integer> Nary;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new ArrayList<>();


    }

    public static void func(){

        for(int i = N ; i <= M ; i++) {
            double a=Math.sqrt(i) ;         //제곱수
            double as ;
            int b;
            b = (int)a;
            as =a-b;
            if(as==0.0) {                   //제곱수를 확인 하기 위해서는 소수점이 0이면 제곱수이므로
                Nary.add(i);
            }
        }
        int sum = 0;
        if(Nary.size()==0){                 //리스트에 없다면 -1
            System.out.println("-1");
        }else {                                 //있다면
            for(int i = 0; i < Nary.size();i++){
                sum+=Nary.get(i);
            }
            System.out.println(sum);
            System.out.println(Nary.get(0));
        }
    }


    public static void main(String[] args) {
        input();
        func();
    }

}
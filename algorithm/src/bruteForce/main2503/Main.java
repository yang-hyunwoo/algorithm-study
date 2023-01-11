package bruteForce.main2503;

import java.util.Scanner;

public class Main {

    static int N,M,strCnt=0,balCnt=0,max=0;
    static int[] Nary;
    static int[] strike;
    static int[] ball;
    static boolean[] visited;

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N];
        strike = new int[N];
        ball = new int[N];
        visited = new boolean[10];
        for(int i = 0 ; i < N ; i++) {
            Nary[i] = scan.nextInt();
            strike[i] = scan.nextInt();
            ball[i] = scan.nextInt();
        }
        start();
    }

    private static void start() {

        for(int i = 111 ; i <=999; i++) {
            if(String.valueOf(i).contains("0")) continue;       //for반복중 0 이 있으면 넘기기
            if(chk(i)) continue;                                //i값에 중복 숫자가 있다면 넘기기
            int count = 0;
            for(int j = 0 ; j < N ;j++) {
                strCnt = 0;
                balCnt = 0;
                for(int z = 0 ; z < 3 ; z++){                                   //숫자 야구 로직 시작
                    if(String.valueOf(Nary[j]).charAt(z) == String.valueOf(i).charAt(z)){       //같은 자리면 스트라이크 증가
                        strCnt++;
                    }
                    if(String.valueOf(Nary[j]).contains(String.valueOf(String.valueOf(i).charAt(z))) && String.valueOf(Nary[j]).charAt(z) != String.valueOf(i).charAt(z)) { //같은 자리는 아니지만 값이 있다면 볼 증가
                        balCnt++;
                    }
                }
                if(strCnt==strike[j] && balCnt==ball[j]) {
                    count++;
                }
            }
            if(count == N){
                max++;
            }
        }
        System.out.println(max);
    }

    private static boolean chk(int i) {
        if(String.valueOf(i).charAt(0)!=String.valueOf(i).charAt(1) && String.valueOf(i).charAt(1)!=String.valueOf(i).charAt(2)&& String.valueOf(i).charAt(0)!=String.valueOf(i).charAt(2)){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        input();
    }

}

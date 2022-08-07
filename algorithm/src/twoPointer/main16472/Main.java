package twoPointer.main16472;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] Nary;
    static int[] cnt;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        String alpha = scan.nextLine();
        Nary = new int[alpha.length()+1];               //문자열의 길이 만큼 배열을 정해준다.
        cnt = new int[27];                              //소문자 알파벳의 갯수 +1을 배열로 정해준다.
        int count = 1 ;
        for(int i = 0 ; i < alpha.length() ; i++){      //Nary 를 1부터 알파벳의 -96을 하여 A :1 B:2 로 변환하여 값을 넣어준다.
            Nary[count] = alpha.charAt(i)-96;
            count++;
        }
        two_pointer();
    }

    public static void two_pointer() {
        int ans = 0 ,R =0,count = 0;                    //ans : 최대길이 R:움직일것 count 문자 갯수
        for(int L = 1  ; L <Nary.length; L++){
            while (R < Nary.length-1  && count<=N) {           //count가 N 개 이하일때까지 while문을 돈다
                    R++;
                    if(cnt[Nary[R]] == 0){                      //만약 cnt[Nary[R] 이 0 이면 count를 증가 시킨다 . count 는 알파벳이 나온 갯수
                        count++;
                    }
                    if(count <= N ){                            //만약 count가 N보다 작다면 ans에 값을 변경해준다.
                        ans = Math.max(ans, R - L + 1);
                    }
                        cnt[Nary[R]]++;                         //값 증가
            }

            if(cnt[Nary[L]] == 1){                              //while문이 종료 된뒤에 cnt[Nary[L] 값이 1일 경우에는 count 값을 감소 시킨다.
                count--;
            }
                cnt[Nary[L]]--;                                 //값을 감소시킨다.

        }

        System.out.println(ans);

    }

    public static void main(String[] args) {
        input();
    }
}

package binarysearch.main1072;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int percent;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        percent = calPercent(N,M , 0);              //처음의 퍼센트를 구한다
        if(percent<100){                               //퍼센트가 100퍼 센트이면 퍼센트가 변화가 없으므로 100이하일때만 이분 탐색을 실행하도록 한다.
            int a = sort();
            if(a == Integer.MAX_VALUE){                //이분탐색을 실행했는데 값이 변화가 없다면 변경 시킬수 없는 값이기 떄문에 -1을 반환해준다.
                a = -1;
            }
            sb.append(a);
        } else {
            sb.append("-1");
        }
        System.out.println(sb.toString());
    }

    public static int calPercent(int X , int Y , int Z){            // 퍼센트 구하는 함수
        long longX = X;                                             //10억+10억*10 으로 값이 int를 벗어 나기때문에 long으로 변환
        long longY = Y;
        int qus = (int) ((((longY+Z)*10) / (longX+Z))*10+(((((longY+Z)*10) % (longX+Z))*10)/(longX+Z)));
        return qus;
    }


    public static int sort() {                                      //이분탐색 시작
            int L = 1000000000 ; int R = 0,ans= Integer.MAX_VALUE ;

            while(L>=R){
                int mid = (L+R)/2;                                  //중앙을 자른다
                if(calPercent(N,M,mid)==percent){                   //만약 percent랑 증가시킨 게임 횟수가 같으면 R을 변환
                    R = mid + 1;
                } else {                                            //그렇지 않다면 percent랑 증가시킨 게임 횟수의 퍼센트가 다르기때문에 ans를 변환환
                   L = mid - 1;
                    ans = Math.min(ans , (L+1));
                }

            }
            return ans;
    }

    public static void main(String[] args) {
        input();
    }

}
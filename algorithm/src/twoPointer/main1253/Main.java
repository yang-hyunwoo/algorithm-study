package twoPointer.main1253;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] Nary;


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            Nary[i] = scan.nextInt();
        }
        Arrays.sort(Nary , 1 , N+1);            //정렬을 한다.
        int ans = 0 ;
        for(int i = 1 ; i <= N ; i++){
            if(two_pointer(i)){                                 // boolean을 받아서 값을 더해 준다.
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static boolean two_pointer(int idx) {
        int R = 0;
        for(int L = 1 ; L <= (N-2) ; L++){                          //N-2 까지 돌며 값을 구한다.
            R = (L+1);                                              //FOR 가 한번씩 돌면 R을 L+1로 초기화 한다.
            while(R<= N && (Nary[R]+Nary[L] <=Nary[idx])) {         //R이 N보다 커질때 까지 돌며 L+R 값이 내가 원하는 값을 비교 한다.
                if(Nary[R]+Nary[L]==Nary[idx] && idx!=R && idx!=L){  // 그 후 값이 같고 값이 R과 L이 아닐때 TRUE로 반환을 해준다.
                    return true;
                }
                R++;                                                  //그게 아니라면 R을 증가 시켜준다.
            }

        }
        return false;
    }

    public static void main(String[] args) {
        input();
    }
}

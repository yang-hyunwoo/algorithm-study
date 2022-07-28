package bruteForce.main1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;//비밀번호 length , 주어지는 영어 갯수
    static char[] Mary,selected; // 주어지는 영어 배열 ,선택된 영어 배열

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Mary= new char[M+1];
        selected = new char[N+1];
        for(int i = 1 ; i <=M; i++) {
            Mary[i] = scan.next().charAt(0);
        }
        Arrays.sort(Mary,1,M+1);
    }


    static void rec_func(int k) {
        if(k==N+1) {		//비밀번호 갯수 까지 다골랐다면
            if(ary_check(selected)) {		//모음과 자음의 갯수를 체크 한다.
                for(int i = 1 ; i < k; i++) {
                    sb.append(selected[i]);
                }
                sb.append("\n");
            }
        } else {		//아직 비밀번호 갯수까지 골라지지 않았다면
            for(int cand = 1 ; cand <= M; cand++) {
                boolean isUsed = false ; //사용 된적이 있는지 확인 하는 변수
                for(int i = 1 ; i < k ; i++) {		//포문을 돌면서 선택된 배열과 주어진 영어 배열에서 같은 값이 있는지 체크
                    if((int)selected[i] >= (int)Mary[cand]) {	//char를 int 아스키 코드 값으로 변환 하여 선택된 배열과 주어진 영어 배열 값을 비교 하여 들어 있거나 값이 더작을 경우에는 사용 되었다고 판단 시킨다.
                        isUsed = true;
                    }
                }
                if(!isUsed) {					//그렇지 않다면 재귀함수를 호출 한다.
                    selected[k] = Mary[cand];
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    static boolean ary_check(char[] ary_chk) {	//모음과 자음 갯수 체크
        boolean true_false = false;
        int[] aeiou_chk = {97,101,105,111,117};  //모음 아스키 코드 값
        int count = 0;
        int count2 = 0;
        for(int i = 1 ; i < ary_chk.length; i++) {
            if((int)ary_chk[i]==aeiou_chk[0] ||
                    (int)ary_chk[i]==aeiou_chk[1] ||
                    (int)ary_chk[i]==aeiou_chk[2] ||
                    (int)ary_chk[i]==aeiou_chk[3] ||
                    (int)ary_chk[i]==aeiou_chk[4])
            {										//모음갯수를 체크
                count++;
            }else {									//자음 갯수 체크
                count2++;
            }
        }
        if(count >=1 && count2 >=2) {
            true_false = true;
            return true_false;
        }
        return true_false;
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}
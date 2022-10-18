package other.main1316;

import java.util.Scanner;

public class Main {

    static int N;
    static String[] Nary;
    static char[] alph;
    static char a = 'a';
    static boolean chk = false;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new String[N];
        alph = new char[26];                    //알파벳 배열 생성

        scan.nextLine();

        for(int i = 0 ; i < N ; i++) {
            Nary[i] = scan.nextLine();
        }

        for(int i = 0 ; i < N; i++) {
            aa();                               //알파벳 배열 초기화
            chk = false;
            for(int j = 0 ; j < Nary[i].length();j++) {
                char ab = Nary[i].charAt(j);
                int ac = (int)ab-(int)a;
                if(alph[ac]==0) {                   //알파벳 배열이 0이면 아무것도 되어있으니 알파벳 배열 증가
                    alph[ac]++;
                } else {
                    char abc = Nary[i].charAt(j-1);         //전에 값을 조회 하고 전 값과 현재 값이 다르면 추후에 나온 값이므로
                    if(abc!=ab){
                        chk = true;
                        break;
                    }
                }
            }
            if(!chk){
                count++;
            }

        }
        System.out.println(count);

    }

    public static void aa() {
        for(int i = 0 ; i <alph.length;i++){
            alph[i] = 0;
        }
    }


    public static void main(String[] args) {
        input();
    }

}

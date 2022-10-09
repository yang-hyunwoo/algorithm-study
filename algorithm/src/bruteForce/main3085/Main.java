package bruteForce.main3085;

import java.util.Scanner;

public class Main {

    static int N,max = 0;
    static char[][] Nary;


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new char[N][N];
        scan.nextLine();

        for(int i = 0 ; i< N ; i++){
            String a = scan.nextLine();
            for(int j = 0 ; j < a.length();j++){
                Nary[i][j] = a.charAt(j);
            }
        }

        //가로 체크
        for(int i = 0 ; i< N ; i++){
            for (int j = 0; j < N-1; j++) {
                char temp = Nary[i][j];         //앞뒤 swap
                Nary[i][j] = Nary[i][j + 1];
                Nary[i][j + 1] = temp;

                chk();

                temp = Nary[i][j];          ////앞뒤 swap 원위치
                Nary[i][j] = Nary[i][j + 1];
                Nary[i][j + 1] = temp;
            }
        }

        for(int i = 0 ; i< N ; i++){
            for (int j = 0; j < N - 1; j++) {
                char temp = Nary[j][i];
                Nary[j][i] = Nary[j + 1][i];
                Nary[j + 1][i] = temp;

                chk();

                temp = Nary[j][i];
                Nary[j][i] = Nary[j + 1][i];
                Nary[j + 1][i] = temp;
            }
        }
        System.out.println(max);
    }

    public static void chk() {
        //가로체크
        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 0 ; j < N-1; j++) {
                if(Nary[i][j]==Nary[i][j+1]){
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        //세로 체크
        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 0 ; j < N-1; j++) {
                if(Nary[j][i]==Nary[j+1][i]){
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
    }

    public static void main(String[] args) {
        input();
    }

}
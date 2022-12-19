package binarysearch.main17245;

import java.util.Scanner;

public class Main {

    static int N;
    static long totalComputer;
    static int[][] computer;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        computer = new int[N][N]; //서버실의 컴퓨터

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ;j++) {
                computer[i][j] = scan.nextInt();
                if(computer[i][j]!=0) {  //총 합의 컴퓨터의 갯수를 구하기
                    totalComputer += computer[i][j];
                }
            }
        }
        binary_search();
    }

    private static void binary_search() {       //매개 변수 탐색
        long L = 10000001, R = 0, ans = Integer.MAX_VALUE;

        while(L>=R) {
            long mid = (L+R)/2;
            if(chk(mid)) {
                L = mid -1;
                ans = Math.min(ans, mid);
            } else {
                R = mid +1;
            }
        }
        if(ans==Integer.MAX_VALUE) {
            ans = 0;
        }
        System.out.println(ans);
    }

    private static boolean chk(long mid) {      //이부분 if문을 제거하고 좀더 간결한 코드로 수정이 가능할듯함
        long count = 0;
        long okComputer = totalComputer / 2 ==0 ? 1 :totalComputer / 2;     //절반 나누고 0인 경우와 0이 아닌 경우
        long okComputerNamuge = totalComputer % 2;      //나눈후 절반 이 0 일때 아닐때 구분해야하기때문에
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(computer[i][j]!=0) {
                    if(computer[i][j]>=mid) {
                        count += mid;
                    } else {
                        count += computer[i][j];
                    }
                }
            }
        }
        if(okComputerNamuge!=0 && okComputer!= 1) {
            if(okComputer < count) {
                return true;
            } else {
                return false;
            }
        } else {
            if(okComputer <= count) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        input();
    }

}
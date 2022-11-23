package bruteForce.main1543;

import java.util.Scanner;

public class Main {

    static String doc,ans;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        doc = scan.nextLine();
        ans = scan.nextLine();
        int docLength = doc.length();           //doc 길이
        String docRep = doc.replace(ans,""); //doc 를 ans로 변경 값
        int docRepLength  = docRep.length();           //변경 값의 길이
        int minusLength = docLength-docRepLength;      //doc 길이와 변경값의 길이 빼기
        int answer = minusLength/ans.length();         //뺀 값에 ans 값 나누기

        System.out.println(answer);
    }


    public static void main(String[] args) {
        input();
    }

}
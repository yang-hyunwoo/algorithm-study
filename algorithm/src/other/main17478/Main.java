package other.main17478;

import java.util.Scanner;

public class Main {

    static int N,M;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
    }

    public static void rec_func(int k) {
        String a = "____";
        sb.append(a.repeat(k)+"\"재귀함수가 뭔가요?\"").append("\n");
        if(k == N) {
            sb.append(a.repeat(k)+"\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
        } else {
            sb.append(a.repeat(k)+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
            sb.append(a.repeat(k)+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
            sb.append(a.repeat(k)+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
            rec_func(k+1);
        }

        sb.append(a.repeat(k)+"라고 답변하였지.").append("\n");



    }



    public static void main(String[] args) {
        input();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        rec_func(0);
        System.out.println(sb.toString());
    }

}
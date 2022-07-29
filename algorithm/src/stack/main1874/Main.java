package stack.main1874;

import java.util.Scanner;
import java.util.Stack;




public class Main {


    static int N,M , sum = 0;
    static int count = 0;

    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> myStack = new Stack<>();

    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        for(int i = 1 ; i <= N ; i++){
            chk(scan.nextInt());
        }
    }

    public static void chk(int A) {
        if(sum < A){
            if(count==0) {
                for (int i = (sum + 1); i <= A; i++) {
                    myStack.push(i);
                    sb.append("+").append("\n");
                }
                myStack.pop();
                sb.append("-").append("\n");
            }
        } else {
                if (myStack.peek() > A) {
                    sb.setLength(0);
                    sb.append("NO");
                    count++;
                } else {
                        if(count==0) {
                            if (A == myStack.pop()) {
                                sb.append("-").append("\n");
                            }
                        }
                }
        }

        sum = Math.max(sum ,A);

    }


    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());

    }

}

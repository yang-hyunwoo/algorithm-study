package stack.main10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N;
    static Stack<Integer> stack = new Stack<>();
    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        for(int i = 0 ; i < N ; i++){
            chk(scan.nextInt());
        }
        sum();
    }
    public static void chk(int A){
        if(A!=0){
            stack.push(A);
        } else {
            stack.pop();
        }
    }

    public static void sum() {
        int length = stack.size();
        int sum = 0;
        for(int i = 0 ; i < length;i++){
            sum += stack.pop();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        input();
    }
}

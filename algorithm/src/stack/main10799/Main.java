package stack.main10799;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Character> myStack = new Stack<>();

    public static void input() {
        Scanner scan = new Scanner(System.in);
        chk(scan.nextLine());
    }

    public static void chk(String A){
        int result = 0;
        for(int i = 0 ; i < A.length(); i++){
            if(A.charAt(i)=='('){
                myStack.push(A.charAt(i));
                continue;
            }
            if(A.charAt(i) == ')') {
                myStack.pop();

                if(A.charAt(i-1) == '('){
                    result += myStack.size();
                } else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        input();
    }

}
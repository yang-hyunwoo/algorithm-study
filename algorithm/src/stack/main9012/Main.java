package stack.main9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        for(int i = 0 ; i < N ; i++){
            chk(scan.nextLine());
        }
    }
    static void chk(String s){
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while(i < s.length()){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(c);
            } else {
                if(stack.size() <1){
                    System.out.println("NO");
                    return ;
                }
                stack.pop();
            }
            i++;
        }
        if(stack.size() >0){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }


    public static void main(String[] args) {
        input();
    }

}
package stack.main4949;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Character> myOneStack = new Stack<>();


    static StringBuilder sb = new StringBuilder();


    public static void chk(String A){
        int i = 0 ;
        while(i < A.length()){
            if(A.charAt(i)=='(' || A.charAt(i)=='['){
                myOneStack.push(A.charAt(i));
            }
            if(A.charAt(i)==')'){
                if(!myOneStack.empty()){
                    if((char)myOneStack.peek() == '('){
                        myOneStack.pop();
                    } else {
                        break;
                    }
                } else {
                    myOneStack.push(A.charAt(i));
                }
            }
            if(A.charAt(i)==']'){
                if(!myOneStack.empty()){
                    if((char)myOneStack.peek() == '['){
                        myOneStack.pop();
                    } else {
                        break;
                    }
                } else {
                    myOneStack.push(A.charAt(i));
                }
            }
            i++;
        }
        if(myOneStack.empty()){
            sb.append("yes").append("\n");
        } else {
            sb.append("no").append("\n");
        }
        myOneStack.clear();
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            String Title = scan.nextLine();
            if(Title.equals(".")){
                break;
            }
            chk(Title);
        }
        System.out.println(sb.toString());
    }

}


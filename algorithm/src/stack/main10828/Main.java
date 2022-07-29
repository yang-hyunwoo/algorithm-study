package stack.main10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main {


    static int N,M;

    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    static Stack<Integer> myStack = new Stack<>();

    public static void input(String input) {
        if(input.contains("push")){
            String[] a = input.split(" ");
            myStack.push(Integer.parseInt(a[1]));
        } else if(input.equals("top")){
            if(myStack.size()==0){
                System.out.println("-1");
            } else {
                System.out.println(myStack.peek());
            }

        } else if(input.equals("empty")){
            if(myStack.empty()){
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        } else if(input.equals("size")){
            System.out.println(myStack.size());
        } else if(input.equals("pop")) {
            if(myStack.size()==0){
                System.out.println("-1");
            } else {
                System.out.println(myStack.pop());
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        String length = br.readLine();
        N = Integer.parseInt(length);
        int i = 0;
        while( i <N){
            i++;
            input(br.readLine());
        }

    }

}
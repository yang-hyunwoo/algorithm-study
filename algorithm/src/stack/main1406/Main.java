package stack.main1406;

import java.io.*;
import java.util.*;

public class Main {

    static Stack<String> leftStack = new Stack<>();
    static Stack<String> rightStack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        String[] arr = str.split("");
        for(String s : arr) {
            leftStack.push(s);
        }

        for (int i = 0; i < M; i++) {
            chk( br.readLine());
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
    }

    public static void chk(String qus) {
        if(qus.contains("L")){
            if(!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        } else if(qus.contains("D")) {
            if(!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
        } else if(qus.contains("B")) {
            if(!leftStack.isEmpty()) {
                leftStack.pop();
            }
        } else if(qus.contains("P")){
            String[] qusSplit = qus.split(" ");
            leftStack.push(qusSplit[1]);
        }
    }
}

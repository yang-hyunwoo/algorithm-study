package queue.main10845;

import java.io.*;
import java.util.ArrayList;

/*
   시간 제한이 작으므로
   BufferedReader / BufferedWriter 사용
 */

public class Main {
    static ArrayList<Integer> queue = new ArrayList<>();            //큐 생성
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            queue(br.readLine());
        }
        bw.close();

    }

    public static void queue(String ans) throws IOException {

        if(ans.contains("push")) {
            String[] s = ans.split(" ");
            queue.add(Integer.parseInt(s[1]));
        } else if(ans.contains("pop")) {
            if(queue.isEmpty()) {
                bw.write(-1+"\n");
            } else {
                bw.write(queue.remove(0)+"\n");
            }
        } else if(ans.contains("size")) {
            bw.write(queue.size()+"\n");
        } else if(ans.contains("empty")) {
            if(queue.isEmpty()) {
                bw.write(1+"\n");
            } else {
                bw.write(0+"\n");
            }
        } else if(ans.contains("front")) {
            if(queue.isEmpty()) {
                bw.write(-1+"\n");
            } else {
                bw.write(queue.get(0)+"\n");
            }
        } else if(ans.contains("back")) {
            if(queue.isEmpty()) {
                bw.write(-1+"\n");
            } else {
                bw.write(queue.get(queue.size()-1)+"\n");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        input();
    }

}
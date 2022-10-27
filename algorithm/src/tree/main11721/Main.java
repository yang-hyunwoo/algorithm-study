package tree.main11721;

import java.util.Scanner;

public class Main {



    public static void input() {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String a = scan.nextLine();

        for(int i = 0 ; i < a.length();i++) {
            if(i%10==0 && i!=0) {
                sb.append("\n");
            }
            sb.append(a.charAt(i));
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        input();
    }

}
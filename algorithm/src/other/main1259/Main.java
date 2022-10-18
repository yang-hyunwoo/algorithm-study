package other.main1259;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        while(!a.equals("0")) {
            String b="";
            for(int i = a.length()-1 ; i >= 0;i--) {
                b+= String.valueOf(a.charAt(i));
            }
           if(a.equals(b)){
               System.out.println("yes");
           } else {
               System.out.println("no");
           }
            a = scan.nextLine();
        }



    }


    public static void main(String[] args) {
        input();
    }

}
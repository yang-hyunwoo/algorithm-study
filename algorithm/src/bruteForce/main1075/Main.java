package bruteForce.main1075;

import java.util.Scanner;

public class Main {

    static String N;
    static int F ;




    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextLine();
        F = scan.nextInt();

        int Nlength = N.length();
        String Nsplit = N.substring(0, N.length() - 2);

        for(int i = 0 ; i<=99;i++) {
            String Nadd;
            String s="";
            if(i<=9){
                s ="0"+String.valueOf(i);
                Nadd = Nsplit+s;
            } else {
                s = String.valueOf(i);
                Nadd = Nsplit+String.valueOf(i);
            }
            if(Integer.parseInt(Nadd)%F==0){
                System.out.println(s);
                break;
            }
        }

    }


    public static void main(String[] args) {
        input();
    }

}
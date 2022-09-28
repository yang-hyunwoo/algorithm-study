package greedy.main2839;

import java.util.Scanner;
public class Main {

    static int N;
    static int count;
    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
    }
    static void rec_func() {
        int a = N%10;
        if(N>=10) {
            if(a==0 ||a==5) {
                count = (N/5);
            } else if(a==1 || a==4 ||a==7) {
                count = (N/10)+(N/10)-1;
                N = N-(5*count);
                count+=(N/3);
            } else if(a==2) {
                count = (N/10)+(N/10)-2;
                N = N-(5*count);
                count+=(N/3);
            } else if(a==3||a==6||a==9) {
                count = (N/10)*2;
                N = N-(5*count);
                count+=(N/3);
            } else if(a==8) {
                count = ((N/10)*2)+1;
                N = N-(5*count);
                count+=(N/3);
            }
        } else {
            if(a==3||a==6||a==9) {
                count = (N/3);
            }else if(a==4||a==7) {
                count = -1;
            }else if(a==5) {
                count = (N/5);
            }else if(a==8) {
                count = (N/5);
                N = N-(5*count);
                count+=(N/3);
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        rec_func();
    }

}
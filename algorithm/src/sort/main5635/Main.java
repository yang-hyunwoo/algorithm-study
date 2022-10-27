package sort.main5635;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class Elem implements Comparable<Elem> {
        String name;
        int dd;
        int mm;
        int yyyy;

        @Override
        public int compareTo(Elem o) {
            if(o.yyyy==yyyy) {
                if(o.mm==mm){
                    return dd-o.dd;
                }else {
                    return mm-o.mm;
                }
            } else {
                return yyyy-o.yyyy;
            }

        }
    }
    static int N;
    static Elem[] Nary;
    static StringBuilder sb = new StringBuilder();
    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Nary = new Elem[N];
        scan.nextLine();
        for(int i = 0 ; i < N ; i++){
            String a = scan.nextLine();
            String[] splita = a.split(" ");
            Nary[i] = new Elem();
            Nary[i].name = splita[0];
            Nary[i].dd = Integer.parseInt(splita[1]);
            Nary[i].mm = Integer.parseInt(splita[2]);
            Nary[i].yyyy = Integer.parseInt(splita[3]);
        }
        Arrays.sort(Nary);

        System.out.println(Nary[N-1].name);
        System.out.println(Nary[0].name);

    }


    public static void main(String[] args) {
        input();
    }

}
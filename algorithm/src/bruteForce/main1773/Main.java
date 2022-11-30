package bruteForce.main1773;

import java.util.Scanner;

public class Main {

    static int people,fire;
    static int[] peopleAry , arr;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        people = scan.nextInt();
        fire = scan.nextInt();

        peopleAry = new int[people];

        for(int i = 0 ; i < people; i++) {
            peopleAry[i] = scan.nextInt();
        }

        int count = solve(fire, peopleAry);
        System.out.println(count);




    }

    private static int solve(int fire, int[] arr) {
        int count = 0;
        for(int i = 1; i<=fire ; i++) {
            for(int j=0;j<arr.length;j++) {
                if(i%arr[j]==0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        input();
    }

}
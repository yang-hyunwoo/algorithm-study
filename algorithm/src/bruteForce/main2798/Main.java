package bruteForce.main2798;

import java.util.Scanner;

public class Main {

    static int N,M,count;
    static int[] Nary,selected;

    static StringBuilder sb = new StringBuilder();


    public static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        Nary = new int[N + 1];
        selected = new int[4];

        for(int i = 1; i <= N ; i++) {
            Nary[i] = scan.nextInt();
        }
    }

    public static void rec_func(int k) {
        if(k==4) {                                              //3장을 뽑았을 경우
            int sum = 0;                                        //3장의 합의 초깃값
            for (int i = 1; i <k; i++) {                        //for 문을 돌면서 3장의 합을 더해준다.
                sum += selected[i];
            }
            if(sum<=M) {                                        //3장의 합이 M의 값보다 작거나 같을 경우
                count = Math.max(count , sum);                  //최댓값을 변경 해준다.
            }
        } else {                                                //3장이 뽑히지 않았을 경우
            for(int cand = 1 ; cand <= N ; cand++) {
                boolean isUsed = false;                         //같은 카드를 고르지 않게 하기 위해
                for(int i = 1;  i <= k ; i++) {
                    if(Nary[cand]==selected[i]){                //같은 카드 일 경우 true 로 변경
                        isUsed = true;
                    }
                }
                if(!isUsed) {                                   //같은 카드가 아닐 경우 재귀 호출을 하여 3장을 뽑을때까지 재귀 호출을 한다.
                    selected[k] = Nary[cand];
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(count);
    }

}
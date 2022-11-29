package binarysearch.main13706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static String N;

    static StringBuilder sb = new StringBuilder();


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bi = new BigInteger(br.readLine());

        System.out.println(bi.sqrt());
    }





    public static void main(String[] args) throws IOException {
        input();
    }

}
package other.main11718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {


    static ArrayList<String> a;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input2 = "";
        while ((input2 = br.readLine()) != null){
            System.out.println(input2);
        }

    }


    public static void main(String[] args) throws IOException {
        input();
    }

}

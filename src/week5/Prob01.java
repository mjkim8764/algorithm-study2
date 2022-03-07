package week5;

/*
    Week5.Prob01 : 해싱
    url : https://www.acmicpc.net/problem/15829
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Prob01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int L = Integer.parseInt(br.readLine());
        String string = br.readLine();

        final int M = 31;
        final int MOD = 1234567891;

        double sum = 0;
        double r = 1;

        for(int i=0; i<string.length(); i++) {
            sum = (sum + (string.charAt(i) - 'a' + 1) * r) % MOD;
            r = (r * M) % MOD;
        }

        System.out.println((int)sum);
        br.close();

    }
}

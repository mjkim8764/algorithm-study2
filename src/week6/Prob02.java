package week6;

/*
    Week6.Prob02 : 팩토리얼
    url : https://www.acmicpc.net/problem/10872
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob02 {
    public static long factorial(long N) {
        if (N == 1 || N == 0) {
            return 1;
        }

        return N * factorial(N - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        System.out.println(factorial(N));
        br.close();
    }
}

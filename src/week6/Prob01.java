package week6;

/*
    Week6.Prob01 : 이진수 변환
    url : https://www.acmicpc.net/problem/10829
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob01 {
    public static void toBinary(long N) {
        if(N >= 2)
            toBinary(N / 2);
        System.out.print(N % 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        toBinary(N);
    }
}

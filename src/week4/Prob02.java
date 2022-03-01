package week4;

/*
    Week4.Prob02 : 진법 변환
    url : https://www.acmicpc.net/problem/2745
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int decimal = 0;
        int length = N.length();
        for(int i=0; i<length; i++) {

            // 자릿수가 0 ~ 9일 때
            if(N.charAt(i) >= 48 && N.charAt(i) <= 57)
                decimal += (Math.pow(B, length - i - 1) * (N.charAt(i) - 48));

            // 자릿수가 A ~ Z일 때
            else if(N.charAt(i) >= 65 && N.charAt(i) <= 90)
                decimal += (Math.pow(B, length - i - 1) * (N.charAt(i) - 55));
        }

        System.out.println(decimal);
    }
}

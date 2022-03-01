package week4;

/*
    Week4.Prob01 : 팩토리얼 진법
    url : https://www.acmicpc.net/problem/5692
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob01 {

    public static int factorialize(String number, int[] factorial) {
        int decimal = 0;
        int length = number.length();

        // 진법 변환
        for(int i=0; i<length; i++) {
            decimal += (factorial[length - i - 1] * (number.charAt(i) - 48));
        }

        return decimal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] factorial = new int[]{1, 2, 6, 24, 120};
        String number = "";
        StringBuilder answer = new StringBuilder();

        number = br.readLine();
        while (!number.equals("0")) {
            answer.append(factorialize(number, factorial)).append("\n");
            number = br.readLine();
        }

        System.out.println(answer);
        br.close();
    }
}


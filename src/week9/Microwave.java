package week9;

/*
    Week9.02 : 전자레인지
    url : https://www.acmicpc.net/problem/10162
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Microwave {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder answer = new StringBuilder();
        int[] buttons = new int[] {300, 60, 10};

        for(int i=0; i<=2; i++){

            // 요리시간이 가장 긴 버튼을 먼저 누름
            answer.append(T / buttons[i]).append(" ");
            T %= buttons[i];

        }

        if(T == 0)
            System.out.println(answer);
        else
            System.out.println("-1");
    }
}

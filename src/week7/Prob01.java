package week7;

/*
    Week7.Prob01 : 계단 오르기
    url : https://www.acmicpc.net/problem/2579
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob01 {
    /*

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // score : 입력값,   total : 점화식을 수행할 총 점수,  step : 계단을 얼마나 연속하여 밟았는지
        int[] score = new int[N + 1];
        int[] total = new int[N + 1];
        int[] step = new int[N + 1];


        for(int i=1; i<=N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        // 점화식의 초기값
        total[1] = score[1];
        step[1] = 1;

        // N == 1 일 때, ArrayIndexException 발생 방지
        if(N >= 2) {
            total[2] = score[1] + score[2];
            step[2] = 2;
        }

        for(int i = 3; i <= N; i++) {
            int twoAndOne = total[i - 3] + score[i - 1] + score[i];
            int oneAndTwo = total[i - 3] + score[i - 2] + score[i];

            if( (twoAndOne > oneAndTwo) || (step[i - 3] == 2)){
                total[i] = twoAndOne;
                step[i] = 2;
            }
            else {
                total[i] = oneAndTwo;
                step[i] = 1;
            }
        }

        System.out.println(total[N]);
    }


     */

}

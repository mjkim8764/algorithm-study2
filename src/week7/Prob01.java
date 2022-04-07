package week7;

/*
    Week7.Prob01 : 계단 오르기
    url : https://www.acmicpc.net/problem/2579
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N];
        int[] total = new int[N];

        for(int i=0; i<N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        // 점화식의 초기값
        total[0] = score[0];

        if(N >= 2)
            total[1] = score[0] + score[1];

        if(N >= 3)
            total[2] = Math.max(score[0], score[1]) + score[2];

        for(int i = 3; i < N; i++)
            total[i] = Math.max(total[i - 3] + score[i - 1] + score[i], total[i - 2] + score[i]);

        System.out.println(total[N - 1]);
    }

}

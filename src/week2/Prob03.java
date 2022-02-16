package week2;

/*
    Week2.Prob03 : 숫자카드 2
    url : https://www.acmicpc.net/problem/10816
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob03 {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 상근이의 숫자 카드들 입력
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(token.nextToken());
            hashmap.put(card, hashmap.getOrDefault(card, 0) + 1);
        }

        // M 입력
        int M = Integer.parseInt(br.readLine());

        // 카운팅할 숫자들 입력
        token = new StringTokenizer(br.readLine(), " ");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int isExist = Integer.parseInt(token.nextToken());
            answer.append(hashmap.getOrDefault(isExist, 0)).append(' ');
        }

        System.out.println(answer);
    }
}

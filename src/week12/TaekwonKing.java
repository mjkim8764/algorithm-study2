package week12;

/*
    Week12.02 : 태권왕
    url : https://www.acmicpc.net/problem/14562
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaekwonKing {

    public static void fight(int S, int T, int idx, int depth, int[] min) {
        if(S == T) {
            min[idx] = Math.min(min[idx], depth);
            return;
        } else if(S < T) {

            // 모든 공격에 대해 경우의 수 검색
            fight(S * 2, T + 3, idx, depth + 1, min);
            fight(S + 1, T, idx, depth + 1, min);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(reader.readLine());
        int[] min = new int[C];

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < C; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            min[i] = Integer.MAX_VALUE;
            fight(S, T, i, 0, min);
        }

        for(int i = 0; i < C; i++)
            builder.append(min[i]).append('\n');

        System.out.print(builder);
    }
}

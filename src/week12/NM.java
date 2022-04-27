package week12;

/*
    Week12.03 : N과 M (2)
    url : https://www.acmicpc.net/problem/15650
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM {

    public static void search(int current, int depth, int[] answer, int N, int M, StringBuilder builder) {
        if(depth == M) {
            for(int data : answer)
                builder.append(data).append(" ");
            builder.append("\n");
            return;
        }
        for(int i = current; i <= N; i++) {
            answer[depth] = i;
            search(i + 1, depth + 1, answer, N, M, builder);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] answer = new int[M];

        StringBuilder builder = new StringBuilder();

        for(int i = 1; i <= N - M + 1; i++) {
            int depth = 0;
            answer[depth] = i;
            search(i + 1, depth + 1, answer, N, M, builder);
        }

        System.out.print(builder);
    }
}

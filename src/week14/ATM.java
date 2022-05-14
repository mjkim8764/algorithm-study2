package week14;

/*
    Week14.03 : 카펫
    url : https://www.acmicpc.net/problem/11399
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] P = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for(int i=0; i<N; i++)
            P[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.sort(P);

        int sum = 0;
        for(int i=0; i<N; i++)
            sum += ( (N - i) * P[i] );

        System.out.println(sum);
    }
}

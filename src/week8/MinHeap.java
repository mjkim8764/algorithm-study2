package week8;

/*
    Week8.01 : MinHeap
    url : https://www.acmicpc.net/problem/1927
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N : 연산의 개수
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        StringBuilder answer = new StringBuilder();

        for(int i=0; i<N; i++) {

            // x : 연산에 대한 정보
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {                      // min 추출연산
                if(queue.isEmpty()) {         // queue가 비어 있으면 0 출력

                    answer.append(0)
                            .append('\n');

                } else {                      // queue가 비어 있지 않으면 poll

                    answer.append(queue.poll())
                            .append('\n');

                }
            } else {
                queue.add(x);
            }
        }

        System.out.println(answer);
    }
}

package week8;

/*
    Week8.02 : MaxHeap
    url : https://www.acmicpc.net/problem/11279
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N : 연산의 개수
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐의 디폴트는 MinHeap 이므로 MaxHeap 으로 구현하기 위한 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder answer = new StringBuilder();

        for(int i=0; i<N; i++) {

            // x : 연산에 대한 정보
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {                      // max 추출연산
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

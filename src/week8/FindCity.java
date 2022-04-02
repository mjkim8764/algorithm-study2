package week8;

/*
    Week8.04 : 특정 거리의 도시 찾기
    url : https://www.acmicpc.net/problem/18352
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindCity {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, M, K, X 정보 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 그래프에 대한 정보
        LinkedList<Integer>[] graph = new LinkedList[N + 1];

        // 링크드 리스트 배열 초기화
        for(int i = 0; i <= N; i++){
            graph[i] = new LinkedList<>();
        }

        // 그래프 구성
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
        }

        br.close();

        // X번 노드부터 해당 노드까지 소요되는 최소 시간 배열
        int[] minDistance = new int[N + 1];
        minDistance[X] = 0;

        // minDistance 초기화
        final int INF = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            if(i != X)
                minDistance[i] = INF;
        }


        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        // Queue 초기값 입력
        pQueue.add(X);

        while(!pQueue.isEmpty()){

            // 탐색을 시작할 노드
            int currentNode = pQueue.poll();

            // 현재 노드와 인접한 노드들의 정보를 가져옴
            for (int nextNode : graph[currentNode]) {

                // 인접한 노드를 거쳐 가는 거리가 더 적다면 갱신 후 노드를 큐에 add
                if (minDistance[nextNode] > minDistance[currentNode] + 1) {
                    minDistance[nextNode] = minDistance[currentNode] + 1;
                    pQueue.add(nextNode);
                }

            }

        }

        // 거리가 K인 노드 찾기
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(minDistance[i] == K) {
                answer.append(i).append('\n');
                cnt++;
            }
        }

        if(cnt == 0)
            answer.append("-1").append('\n');

        System.out.println(answer);

    }
}

package week8;

/*
    Week8.05 : 가장 먼 노드
    url : https://programmers.co.kr/learn/courses/30/lessons/49189
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {

    public static void dijkstra(LinkedList<Integer>[] graph, int[] minDistance, Queue<Integer> queue) {

        while(!queue.isEmpty()) {

            int currentNode = queue.poll();
            for(int nextNode : graph[currentNode]) {
                if(minDistance[nextNode] > minDistance[currentNode] + 1) {
                    minDistance[nextNode] = minDistance[currentNode] + 1;
                    queue.add(nextNode);
                }
            }

        }

    }

    public static int solution(int n, int[][] edge){
        int answer = 0;

        LinkedList<Integer>[] graph = new LinkedList[n + 1];

        // graph 초기화
        for(int i = 1; i <= n; i++)
            graph[i] = new LinkedList<>();

        // graph 구성
        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }

        // 최단 거리를 저장할 배열 선언 및 초기화
        int[] minDistance = new int[n + 1];
        final int INF = Integer.MAX_VALUE;

        minDistance[1] = 0;
        for(int i = 2; i <= n; i++) {
            minDistance[i] = INF;
        }

        // bfs에 이용할 queue
        Queue<Integer> queue = new LinkedList<>();

        // queue 초기값 설정 및 다익스트라
        queue.add(1);
        dijkstra(graph, minDistance, queue);

        // max : minDistance 배열 중 최대값
        int max = Arrays.stream(minDistance).max().getAsInt();

        // answer 카운팅
        for(int i = 1; i <= n; i++)
            if(max == minDistance[i])
                answer++;

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n, edge));
    }
}

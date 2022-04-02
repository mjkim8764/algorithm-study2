package week8;

/*
    Week8.03 : 배달
    url : https://programmers.co.kr/learn/courses/30/lessons/12978
*/

import java.util.*;

public class Delivery {

    // 그래프 구성에 쓸 Edge 정보
    static class Edge{

        // 인접한 노드 번호
        int nextNode;

        // nextNode 까지 걸리는 시간
        int time;

        // Constructor
        Edge(int nextNode, int time) {
            this.nextNode = nextNode;
            this.time = time;
        }

    }

    // 그래프 구성
    public static void addEdge(int x, int y, int time, LinkedList<Edge>[] graph){
        graph[x].add(new Edge(y, time));
        graph[y].add(new Edge(x, time));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 그래프에 대한 정보
        LinkedList<Edge>[] graph = new LinkedList[N + 1];

        // 1번 노드부터 해당 노드까지 소요되는 최소 시간
        int[] minTime = new int[N + 1];
        minTime[1] = 0;

        // minTime 초기화
        final int INF = Integer.MAX_VALUE;
        for(int i = 2; i <= N; i++) {
            minTime[i] = INF;
        }

        // 링크드 리스트 배열 초기화
        for(int i = 0; i <= N; i++){
            graph[i] = new LinkedList<>();
        }

        // Priority Queue에서 정렬하는 기준을 time 오름차순으로 설정
        PriorityQueue<Edge> pQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return edge1.time - edge2.time;
            }
        });

        // 그래프 정보(road) 입력
        for(int i = 0; i < road.length; i++) {
            addEdge(road[i][0], road[i][1], road[i][2], graph);
        }

        // Queue 초기값 입력
        pQueue.add(new Edge(1, 0));

        while(!pQueue.isEmpty()){

            // 탐색을 시작할 노드
            int currentNode = pQueue.poll().nextNode;

            // 현재 노드에서 연결된 Edge들의 정보를 가져옴
            for (Edge edge : graph[currentNode]) {

                // Edge를 거쳐 가는 것이 시간이 더 적게 걸린다면 갱신 후 edge를 큐에 add
                if (minTime[edge.nextNode] > minTime[currentNode] + edge.time) {
                    minTime[edge.nextNode] = minTime[currentNode] + edge.time;
                    pQueue.add(edge);
                }

            }

        }

        // K시간 이내로 소요되는 노드들 카운팅
        for(int i = 1; i <= N; i++) {
            if(minTime[i] <= K)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int N1 = 5;
        int[][] road1 = new int[][] {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K1 = 3;

        int N2 = 6;
        int[][] road2 = new int[][] {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int K2 = 4;

        System.out.println(solution(N1, road1, K1));
        System.out.println(solution(N2, road2, K2));
    }

}

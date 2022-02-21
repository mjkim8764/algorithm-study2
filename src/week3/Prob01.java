package week3;

/*
    Week3.Prob01 : DFS와 BFS
    url : https://www.acmicpc.net/problem/1260
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob01 {

    public static void addEdge(int x, int y, LinkedList<Integer>[] graph) {
        graph[x].add(y);
        graph[y].add(x);
    }

    public static void DFS(int node, LinkedList<Integer>[] graph, boolean[] visitedDfs, LinkedList<Integer> dfsList) {
        if(!visitedDfs[node] && !dfsList.contains(node)) {
            visitedDfs[node] = true;
            dfsList.add(node);
            Iterator<Integer> ir = graph[node].iterator();
            while(ir.hasNext()) {
                DFS(ir.next(), graph, visitedDfs, dfsList);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] graph = new LinkedList[N];
        LinkedList<Integer> dfsList = new LinkedList<>();
        boolean[] visitedDfs = new boolean[N];
        boolean[] visitedBfs = new boolean[N];

        // 초기화
        for(int i=0; i<N; i++)
            graph[i] = new LinkedList<>();

        // 그래프 구성
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            addEdge(x, y, graph);
        }

        // 리스트 정렬
        for(int i=0; i<N; i++)
            Collections.sort(graph[i]);

        // DFS (recursive)
        DFS(V - 1, graph, visitedDfs, dfsList);

        // DFS 출력
        StringBuilder answer = new StringBuilder();
        Iterator<Integer> ir = dfsList.iterator();
        while(ir.hasNext()) {
            answer.append(ir.next() + 1).append(" ");
        }
        answer.append("\n");


        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V - 1);
        visitedBfs[V - 1] = true;
        answer.append(V).append(" ");

        while(!queue.isEmpty()) {
            ir = graph[queue.poll()].iterator();
            while(ir.hasNext()) {
                int node = ir.next();
                if(!visitedBfs[node]) {
                    queue.add(node);
                    visitedBfs[node] = true;
                    answer.append(node + 1).append(" ");
                }
            }
        }

        System.out.print(answer);
        br.close();
    }
}

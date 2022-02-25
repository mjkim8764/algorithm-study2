package week3;

/*
    Week3.Prob02 : 바이러스
    url : https://www.acmicpc.net/problem/2606
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Prob02 {

    public static void addEdge(int computer1, int computer2, LinkedList<Integer>[] graph) {
        graph[computer1].add(computer2);
        graph[computer2].add(computer1);
    }

    public static void dfs(int node, LinkedList<Integer>[] graph, boolean[] visited) {
        Iterator<Integer> ir = graph[node].iterator();
        while(ir.hasNext()) {
            int nextNode = ir.next();
            if(!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode, graph, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] graph = new LinkedList[V + 1];

        // 그래프 초기화
        for(int i=0; i<=V; i++)
            graph[i] = new LinkedList<>();

        StringTokenizer st;

        // 그래프 구성
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int computer1 = Integer.parseInt(st.nextToken());
            int computer2 = Integer.parseInt(st.nextToken());

            addEdge(computer1, computer2, graph);
        }

        boolean[] visited = new boolean[V + 1];

        // 1부터 dfs
        dfs(1, graph, visited);

        
        // 방문한 노드(바이러스에 걸린 컴퓨터) 갯수 확인
        int count = 0;
        for(int i=1; i<=V; i++) {
            if(visited[i])
                count++;
        }

        // 1번 컴퓨터를 제외한 수를 출력
        System.out.println(count - 1);

    }
}

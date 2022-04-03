package week7;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode207 {

    public static boolean isCycle(LinkedList<Integer>[] graph, boolean[] visited, Queue<Integer> queue, int startNode) {

        while(!queue.isEmpty()) {

            int node = queue.poll();

            for(int nextNode : graph[node]) {
                if(nextNode == startNode)
                    return true;
                else if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }

        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites){
        LinkedList<Integer>[] graph = new LinkedList[numCourses];

        // Initialize
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        // add Edge
        for(int i = 0; i < prerequisites.length; i++)
            graph[prerequisites[i][1]].add(prerequisites[i][0]);

        // BFS for all nodes;
        for(int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            if(isCycle(graph, visited, queue, i))
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][] {{1, 0}};

        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][] {{1, 0}, {0, 1}};

        int numCourses3 = 3;
        int[][] prerequisites3 = new int[][] {{0, 1}, {0, 2}, {1, 2}};

        System.out.println(canFinish(numCourses1, prerequisites1));
        System.out.println(canFinish(numCourses2, prerequisites2));
        boolean answer = canFinish(numCourses3, prerequisites3);
        System.out.println(answer);
    }
}

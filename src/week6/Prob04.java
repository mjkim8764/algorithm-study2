package week6;

/*
    Week6.Prob04 : 네트워크
    url : https://programmers.co.kr/learn/courses/30/lessons/43162
*/

public class Prob04 {

    public static void dfs(int currentComputer, int n, boolean[] visited, int[][] computers) {
        for(int i=0; i<n; i++) {

            // 현재 컴퓨터와 연결된 컴퓨터 중에 방문하지 않은 것을 찾아서 방문함.
            if( (i != currentComputer) && (computers[currentComputer][i] == 1) && (!visited[i]) ) {
                visited[i] = true;
                dfs(i, n, visited, computers);
            }
        }
    }

    public static void solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]) {   // 방문 기록이 없다는 것은 새로운 네트워크라는 의미이므로 answer 증가
                answer++;
                dfs(i, n, visited, computers);
            }
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 3;
        int[][] computers1 = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        solution(n1, computers1);
        solution(n2, computers2);
    }
}

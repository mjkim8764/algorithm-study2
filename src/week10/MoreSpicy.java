package week10;

/*
    Week10.02 : 더 맵게
    url : https://programmers.co.kr/learn/courses/30/lessons/42626
*/

import java.util.PriorityQueue;

public class MoreSpicy {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        boolean isCreatable = false;

        for(int data : scoville) {
            pQueue.add(data);
        }

        while(!pQueue.isEmpty()) {

            // peek 값은 최소값이므로, K보다 크다면 섞지 않고 break
            if(pQueue.peek() >= K) {
                isCreatable = true;
                break;
            }

            // 남은 음식이 1개 뿐이면 새로운 음식을 만들 수 없으므로 break
            if(pQueue.size() == 1)
                break;
            else {
                int firstFood = pQueue.poll();
                int secondFood = pQueue.poll();

                // 새로운 음식을 만듬
                pQueue.add(firstFood + (secondFood * 2));
                answer++;
            }

        }

        if(isCreatable)
            return answer;

        return -1;
    }

    public static void main(String[] args) {
        int[] scoville = new int[] {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }
}

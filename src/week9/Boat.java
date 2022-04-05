package week9;

/*
    Week9.03 : 구명보트
    url : https://programmers.co.kr/learn/courses/30/lessons/42885
*/

import java.util.Arrays;

public class Boat {

    public static int solution(int[] people, int limit) {
        int answer = 0;

        // 무게 순으로 오름차순 정렬
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while(left <= right) {

            // 가장 가벼운 사람과 가장 무거운 사람이 함께 탈 수 있는지 체크
            // 1. 가능하면 같이 태움
            // 2. 그렇지 않으면 가장 무거운 사람만 태움
            if(people[left] + people[right] > limit) {
                right--;
                answer++;
            } else {
                left++;
                right--;
                answer++;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] people1 = new int[] {70, 50, 80, 50};
        int limit1 = 100;

        int[] people2 = new int[] {70, 80, 50};
        int limit2 = 100;

        int[] people3 = new int[] {40, 50, 50, 60, 70, 80, 90};
        int limit3 = 100;

        // Expected : 3
        System.out.println(solution(people1, limit1));

        // Expected : 3
        System.out.println(solution(people2, limit2));

        // Expected : 5
        System.out.println(solution(people3, limit3));
    }

}

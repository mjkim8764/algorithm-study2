package week1;

/*
    week1.Prob01 :  기능 개발
    url : https://programmers.co.kr/learn/courses/30/lessons/42586
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prob01 {
    public static void solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        //queue에 개발날짜 저장
        for(int i=0; i<progresses.length; i++) {
            int day =  ((100 - progresses[i]) % speeds[i]  == 0) ?
                        (100 - progresses[i]) / speeds[i] :
                        (100 - progresses[i]) / speeds[i] + 1;
            queue.add(day);
        }

        //queue에서 하나 꺼내서 초기값으로 설정
        int publish = queue.poll();

        // 한 번에 배포할 수 있는 기능 수
        int methods = 1;

        while(!queue.isEmpty()) {
            int current_publish = queue.poll();
            if(publish < current_publish) {      // 다음 기능을 한번에 배포할 수 없다면
                result.add(methods);             // 현재까지의 기능 수를 저장
                methods = 1;                     // 배포 기능 수 초기화
                publish = current_publish;
            }
            else {                               // 다음 기능까지 배포 가능하면
                methods++;                       // 배포 기능 수 증가
            }
        }

        result.add(methods);                     // 마지막 기능까지 배포 완료

        int[] answer = result.stream().mapToInt(v -> v).toArray();

        for(int i=0; i<answer.length; i++)
            System.out.print(answer[i] + " ");
        System.out.println();

    }

    public static void main(String[] args) {
        int[] progresses1 = new int[] {93, 30, 55};
        int[] speeds1 = new int[] {1, 30, 5};

        int[] progresses2 = new int[] {95, 90, 99, 99, 80, 99};
        int[] speeds2 = new int[] {1, 1, 1, 1, 1, 1};

        int[] progresses3 = new int[] {40, 93, 30, 55, 60, 65};
        int[] speeds3 = new int[] {60, 1, 30, 5, 10, 7};

        int[] progresses4 = new int[] {93, 30, 55, 60, 40, 65};
        int[] speeds4 = new int[] {1, 30, 5, 10, 60, 7};


        //solution(progresses1, speeds1);
        //solution(progresses2, speeds2);
        solution(progresses3, speeds3);
        //solution(progresses4, speeds4);
    }

}

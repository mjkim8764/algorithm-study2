package week10;

/*
    Week10.03 : 이중우선순위큐
    url : https://programmers.co.kr/learn/courses/30/lessons/42628
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {

            String[] splitCommand = operation.split(" ");

            String command = splitCommand[0];
            int number = Integer.parseInt(splitCommand[1]);

            if("I".equals(command)) {    // 주어진 숫자 삽입
                minQueue.add(number);
                maxQueue.add(number);
            }
            else if("D".equals(command) && number == -1) {    // 최소값 삭제
                if (!minQueue.isEmpty())
                    maxQueue.remove(minQueue.poll());
            } else if("D".equals(command) && number == 1) {     // 최대값 삭제
                if(!maxQueue.isEmpty())
                    minQueue.remove(maxQueue.poll());
            }

        }

        if(!minQueue.isEmpty())
            return new int[] {maxQueue.poll(), minQueue.poll()};
        else
            return new int[] {0, 0};
    }

    public static void main(String[] args) {
        String[] operations1 = {"I 16", "D 1"};
        String[] operations2 = {"I 7", "I 5", "I -5", "D -1"};
        String[] operations3 = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};

        int[] return1 = solution(operations1);
        System.out.println(return1[0] + " " + return1[1]);

        int[] return2 = solution(operations2);
        System.out.println(return2[0] + " " + return2[1]);

        int[] return3 = solution(operations3);
        System.out.println(return3[0] + " " + return3[1]);
    }
}

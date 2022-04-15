package week10;

/*
    Week10.04 : 더 맵게
    url : https://programmers.co.kr/learn/courses/30/lessons/42627
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

    static class Task {

        int start;
        int length;

        Task(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    public static int solution(int[][] jobs) {
        int sum = 0;

        // job 시작 시간을 기준으로 오름차순 정렬
        // job 시작 시간이 같다면 job 길이 순으로 오름차순
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] task1, int[] task2) {
                if(task1[0] == task2[0])
                    return task1[1] - task2[1];
                return task1[0] - task2[0];
            }
        });

        // PriorityQueue 는 task length 로 정렬되도록 함.
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                return task1.length - task2.length;
            }
        });


        taskQueue.add(new Task(jobs[0][0], jobs[0][1]));
        int idx = 1;
        int current = 0;

        while(!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            current = Math.max(task.start, current) + task.length;
            sum += (current - task.start);

            while(idx < jobs.length && current >= jobs[idx][0]) {
                taskQueue.add(new Task(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(idx < jobs.length && taskQueue.isEmpty()) {
                taskQueue.add(new Task(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

        }

        // System.out.println(sum + " " + idx);

        return sum / idx;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
        System.out.println(solution(new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}));
    }

}

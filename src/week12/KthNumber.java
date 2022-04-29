package week12;

/*
    Week12.04 : K번째 수
    url : https://programmers.co.kr/learn/courses/30/lessons/42748
*/

import java.util.Arrays;

public class KthNumber {
    public static void solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int[] cutting = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(cutting);
            answer[i] = cutting[commands[i][2] - 1];
        }

        for(int i = 0; i < commands.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void main(String[] args) {
        solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                 new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}

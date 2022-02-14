package week2;

/*
    Week2.Prob01 : 모의고사
    url : https://programmers.co.kr/learn/courses/30/lessons/42840
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Prob01 {

    public static void solution(int[] answers){
        ArrayList<Integer> al = new ArrayList<>();
        int[] student1 = new int[] {1, 2, 3, 4, 5};
        int[] student2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int length = answers.length;
        int[] answersList = new int[] {0, 0, 0};

        for(int i=0; i<length ;i++) {
            if (answers[i] == student1[i % 5]) {
                answersList[0]++;
            }
            if (answers[i] == student2[i % 8]) {
                answersList[1]++;
            }
            if (answers[i] == student3[i % 10]) {
                answersList[2]++;
            }
        }

        int max = Arrays.stream(answersList).max().getAsInt();
        for(int i=0; i<3; i++){
            if(answersList[i] == max){
                al.add(i+1);
            }
        }

        int[] answer = al.stream().mapToInt(v -> v).toArray();

        for(int i=0; i<answer.length; i++)
            System.out.print(answer[i] + " ");

        System.out.println();

    }

    public static void main(String[] args) {
        int[] answers1 = new int[] {1, 2, 3, 4, 5};
        int[] answers2 = new int[] {1, 3, 2, 4, 2};
        solution(answers1);
        solution(answers2);
    }
}
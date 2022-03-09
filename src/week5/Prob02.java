package week5;

/*
    Week5.Prob02 : 완주하지 못한 선수
    url : https://programmers.co.kr/learn/courses/30/lessons/42576
*/

import java.util.Arrays;

public class Prob02 {

    public static void solution(String[] participant, String[] completion) {
        String answer = "";

        int participants = participant.length;
        int completions = completion.length;

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completions; i++) {
            if (!participant[i].equals(completion[i])) {
                answer += participant[i];
                break;
            }
        }

        if (answer.equals("")) {
            answer += participant[participants - 1];
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};

        String[] completion1 = {"eden", "kiki"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        solution(participant1, completion1);
        solution(participant2, completion2);
        solution(participant3, completion3);

    }
}
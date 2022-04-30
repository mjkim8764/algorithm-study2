package week11;

import java.util.ArrayList;

public class Dart {

    public static int solution(String dartResult) {
        ArrayList<Integer> score = new ArrayList<>();
        int idx = 0;
        int listIdx = 0;

        while(idx < dartResult.length()) {
            if(dartResult.charAt(idx) >= '0' && dartResult.charAt(idx) <= '9') {
                if(dartResult.charAt(idx) == '1' && dartResult.charAt(idx + 1) == '0') {
                    score.add(10);
                    idx++;
                } else {
                    score.add(dartResult.charAt(idx) - 48);
                }
                idx++;
                listIdx++;
            } else if(dartResult.charAt(idx) == '*') {
                score.set(listIdx - 1, score.get(listIdx - 1) * 2);
                if(listIdx >= 2) {
                    score.set(listIdx - 2, score.get(listIdx - 2) * 2);
                }
                idx++;
            } else if(dartResult.charAt(idx) == '#') {
                score.set(listIdx - 1, score.get(listIdx - 1) * -1);
                idx++;
            } else if(dartResult.charAt(idx) == 'S') {
                idx++;
            } else if(dartResult.charAt(idx) == 'D') {
                score.set(listIdx - 1, score.get(listIdx - 1) * score.get(listIdx - 1));
                idx++;
            } else if(dartResult.charAt(idx) == 'T') {
                score.set(listIdx - 1, score.get(listIdx - 1) * score.get(listIdx - 1) * score.get(listIdx - 1));
                idx++;
            }
        }

        return score.stream().mapToInt(v -> v).sum();
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }
}

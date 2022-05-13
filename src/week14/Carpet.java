package week14;

/*
    Week14.02 : 카펫
    url : https://programmers.co.kr/learn/courses/30/lessons/42842
*/

import java.util.ArrayList;

public class Carpet {
    public static void solution(int brown, int yellow) {
        ArrayList<Integer> bx = new ArrayList<>();
        ArrayList<Integer> by = new ArrayList<>();
        ArrayList<Integer> yx = new ArrayList<>();
        ArrayList<Integer> yy = new ArrayList<>();
        int[] answer = new int[2];

        brown += yellow;

        // yellow 가로, 세로 조합 입력
        for(int i=1; i<=(int)Math.sqrt(yellow); i++){
            if(yellow % i == 0) {
                yy.add(i);
                yx.add(yellow / i);
            }
        }

        // brown 가로, 세로 조합 입력
        for(int i=1; i<=(int)Math.sqrt(brown); i++){
            if(brown % i == 0){
                by.add(i);
                bx.add(brown / i);
            }
        }

        // (brown의 가로 & 세로) = (yellow의 가로 & 세로) + 2
        for(int i=0; i<bx.size(); i++) {
            for(int j=0; j<yx.size(); j++) {
                if( (bx.get(i) == yx.get(j) + 2) && (by.get(i) == yy.get(j) + 2)) {
                    answer[0] = bx.get(i);
                    answer[1] = by.get(i);
                }
            }
        }

        for(int i=0; i< answer.length; i++)
            System.out.print(answer[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        solution(10, 2);
        solution(8, 1);
        solution(24, 24);
    }
}

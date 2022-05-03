package week13;

/*
    Week13.02 : H-Index
    url : https://programmers.co.kr/learn/courses/30/lessons/42747
*/


import java.util.ArrayList;
import java.util.Collections;

public class Hindex {

    public static void solution(int[] citations) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<citations.length; i++) {
            list.add(citations[i]);
        }

        list.sort(Collections.reverseOrder());

        for(int i=0; i<citations.length; i++){
            if(list.get(i) >= i+1)
                answer = Math.max(answer,i+1);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        solution(new int[] {3, 0, 6, 1, 5});
    }
}

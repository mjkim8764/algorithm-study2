package week10;

/*
    Week10.05 : 가장 큰 수
    url : https://programmers.co.kr/learn/courses/30/lessons/42746
*/

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {

    public static String solution(int[] numbers) {
        String answer = "";

        // 모든 값이 0이면 0을 이어서 출력하지 않고 그냥 0만 출력
        if(Arrays.stream(numbers).sum() == 0)
            return "0";

        String[] numberString = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            numberString[i] = Integer.toString(numbers[i]);

        Arrays.sort(numberString, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int n1 = Integer.parseInt(s1 + s2);
                int n2 = Integer.parseInt(s2 + s1);
                return n2 - n1;
            }
        });

        for(String number : numberString)
            answer = answer + number + " ";

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {6, 10, 2}));
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
        System.out.println(solution(new int[] {1, 10, 100, 1000}));
        System.out.println(solution(new int[] {23, 232, 21, 212}));
        System.out.println(solution(new int[] {999, 99, 9, 998}));
        System.out.println(solution(new int[] {199, 192, 19, 191, 190}));
        System.out.println(solution(new int[] {0, 0, 0, 0, 0, 0, 0}));

        /*
        String s1 = "0";
        String s2 = "0";
        int n = Integer.parseInt(s1 + s2);
        System.out.println(n);
        */
    }
}

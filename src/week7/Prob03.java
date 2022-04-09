package week7;

/*
    Week7.Prob03 : N으로 표현
    url : https://programmers.co.kr/learn/courses/30/lessons/42895
*/

import java.util.HashSet;

public class Prob03 {
    
    public static int solution(int N, int number) {
        int answer = 0;

        // set[i] : i 자리로 표현할 수 있는 모든 값들을 저장하고 있는 set
        HashSet<Integer>[] set = new HashSet[9];

        // set 초기화
        for(int i = 0; i <= 8; i++) {
            set[i] = new HashSet<>();
        }

        // 5, 55, 555... 등을 먼저 set에 넣음
        for(int i = 1; i <= 8; i++) {

            int sum = 0;
            for(int j = 0; j <= i - 1; j++) {
                sum += (N * Math.pow(10, j));
            }

            set[i].add(sum);
        }

        if(N == number) {
            return 1;
        } else {
            for(int i = 2; i <= 8; i++){

                for(int j = 1; j < i; j++) {

                    // set[i] = set[1 ~ i-1], set[i-1 ~ 1] 사칙연산
                    for(int k : set[j]) {
                         for(int l : set[i - j]) {
                             set[i].add(k + l);
                             set[i].add(k * l);
                             set[i].add(k - l);
                             if(l != 0)
                                 set[i].add(k / l);
                        }
                    }
                }

                if(set[i].contains(number))
                    return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int N1 = 5;
        int number1 = 12;

        int N2 = 2;
        int number2 = 11;

        System.out.println(solution(N1, number1));
        System.out.println(solution(N2, number2));
    }
}

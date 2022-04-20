package week11;

/*
    Week11.01 : 숫자 문자열과 영단어
    url : https://programmers.co.kr/learn/courses/30/lessons/81301
*/

public class NumberString {

    public static int solution(String s) {
        String answer = "";
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int length = s.length();


        for(int i = 0; i < length; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                answer += s.charAt(i);
            else {
                for (int j = 0; j <= 9; j++) {
                    if (i + number[j].length() <= length && s.substring(i, i + number[j].length()).equals(number[j])) {
                        answer += Integer.toString(j);
                        i = i + number[j].length() - 1;
                        break;
                    }
                }
            }
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }
}

package week6;

/*
    Week6.Prob03 : 괄호 변환
    url : https://programmers.co.kr/learn/courses/30/lessons/60058
*/

public class Prob03 {

    // 균형잡힌 문자열이 올바른 문자열인지 체크
    public static boolean isCorrect(String s) {
        if(s.charAt(0) == ')')
            return false;

        return true;
    }

    // 균형잡힌 문자열이 처음 완성되는 index를 반환
    public static int getFirstIndexOfBalanced(String s) {
        int left = 0;
        int right = 0;
        int length = s.length();
        for(int i=0; i<length; i++) {

            if(s.charAt(i) == '(')
                left++;
            else if(s.charAt(i) == ')')
                right++;

            if(left == right)
                break;
        }
        return left + right;
    }

    // 괄호 방향 변환
    public static String convert(String s){
        String convertString = "";

        for(int i=0; i<s.length(); i++) {
            convertString = (s.charAt(i) == '(') ? (convertString + ')') : (convertString + '(');
        }

        return convertString;
    }

    public static String split(String s) {

        // 빈 문자열일 때는 반환
        if(s.length() == 0)
            return s;

        // u가 올바른 문자열인지 체크 후 프로세스 분기
        if (isCorrect(s.substring(0, getFirstIndexOfBalanced(s)))){
            // 올바른 문자열일 때는 3 수행
            s = s.substring(0, getFirstIndexOfBalanced(s)) + split(s.substring(getFirstIndexOfBalanced(s)));
        }
        else {
            // 올바른 문자열이 아닐 때는 4 수행
            s = "(" + split(s.substring(getFirstIndexOfBalanced(s))) + ")" + convert(s.substring(1, getFirstIndexOfBalanced(s) - 1));
        }

        return s;
    }

    public static void solution(String p) {
        String answer = "";
        answer = answer + split(p);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        solution(p1);
        solution(p2);
        solution(p3);

    }
}

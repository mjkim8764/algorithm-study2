package week11;

/*
    Week11.02 : 신규 아이디 추천
    url : https://programmers.co.kr/learn/courses/30/lessons/72410
*/

public class NewId {

    public static String solution(String new_id) {
        String answer = "";

        // 1. 소문자로 변환
        new_id = new_id.toLowerCase();

        // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        int idx = 0;
        while(idx < new_id.length() ) {
            if ((new_id.charAt(idx) != '-') && (new_id.charAt(idx) != '_') &&
                    (new_id.charAt(idx) != '.') && !(new_id.charAt(idx) >= 'a' && new_id.charAt(idx) <= 'z') &&
                    !(new_id.charAt(idx) >= '0' && new_id.charAt(idx) <= '9')) {

                new_id = new_id.substring(0, idx) + new_id.substring(idx + 1, new_id.length());

            } else {
                idx++;
            }
        }

        // 3. 마침표(.)가 2번 이상 연속되는 부분을 하나의 마침표(.)로 치환
        int length = new_id.length();
        for(int i = 0; i <= length / 2; i ++)
           new_id = new_id.replace("..", ".");

        // 4. "." 이라면 "aaa" 반환
        if(".".equals(new_id))
            return "aaa";

        // 5. 처음과 끝의 마침표 제거
        if(new_id.charAt(0) == '.')
            new_id = new_id.substring(1);

        if(new_id.charAt(new_id.length() - 1) == '.')
            new_id = new_id.substring(0, new_id.length() - 1);

        // 6. 16자 이상이면 첫 15개의 문자 제외한 나머지 제거하고 끝의 마침표 제거
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.')
                new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 7. 2글자 이하면 마지막 문자를 길이가 3이 될 때까지 반복해서 붙임.
        if(new_id.length() == 1)
            return new_id + new_id + new_id;
        else if(new_id.length() == 2)
            return new_id + new_id.charAt(1);

        return new_id;
    }

    public static void main(String[] args) {
        // System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        // System.out.println(solution("z-+.^."));
        // System.out.println(solution("=.="));
        // System.out.println(solution("123_.def"));
        // System.out.println(solution("abcdefghijklmn.p"));
        System.out.println(solution(".........................."));
    }
}

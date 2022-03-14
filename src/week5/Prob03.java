package week5;

/*
    Week5.Prob03 : 전화번호 목록
    url : https://programmers.co.kr/learn/courses/30/lessons/42577
*/

import java.util.Arrays;

public class Prob03 {

    public static void solution(String[] phone_book) {
        int length = phone_book.length;

        // 정렬
        Arrays.sort(phone_book);

        // 현재 문자열이 앞의 문자열로 시작하면 false 후 종료
        for(int i=1; i<length; i++) {
            if( phone_book[i].startsWith(phone_book[i - 1]) ) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    public static void main(String[] args) {
        String[] phone_book1 = { "119", "97674223", "1195524421"};
        String[] phone_book2 = { "123", "456", "789" };
        String[] phone_book3 = { "12", "123", "1235", "567", "88"};

        solution(phone_book1);
        solution(phone_book2);
        solution(phone_book3);


    }
}

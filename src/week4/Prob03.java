package week4;

/*
    Week4.Prob03 : 비밀지도
    url : https://programmers.co.kr/learn/courses/30/lessons/17681
 */

public class Prob03 {

    public static void solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++) {
            answer[i] = "" + Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = answer[i].replace('1', '#').replace('0', ' ');
            answer[i] = String.format("%" + n + "s", answer[i]);
        }

        for(int i=0; i<n; i++){
            System.out.println(answer[i]);
        }
    }

    public static void main(String[] args) {

        int n1 = 5;
        int[] arr11 = new int[]{9, 20, 28, 18, 11};
        int[] arr21 = new int[]{30, 1, 21, 17, 28};

        int n2 = 6;
        int[] arr12 = new int[]{46, 33, 33, 22, 31, 50};
        int[] arr22 = new int[]{27, 56, 19, 14, 14, 10};

        solution(n1, arr11, arr21);
        solution(n2, arr12, arr22);

    }
}

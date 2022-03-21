package week7;

/*
    Week7.Prob02 : 정수 삼각형
    url : https://programmers.co.kr/learn/courses/30/lessons/43105
*/

public class Prob02 {

    public static int solution(int[][] triangle) {
        int length = triangle.length;
        int[][] sum = new int[length][length];

        // 초기값 입력
        sum[0][0] =  triangle[0][0];

        // 점화식 : sum[i][j] = max(sum[i - 1][j - 1], sum[i - 1][j]) + triangle[i][j]
        for(int i = 1; i < length; i++) {
            for(int j = 0; j <= i; j++) {
                sum[i][j] = (j == 0) ?
                        sum[i - 1][j] + triangle[i][j] :
                        Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + triangle[i][j];
            }
        }

        // 마지막 행에서 max 값을 찾음
        int max = -1;
        for(int i = 0; i < length; i++) {
            if(max < sum[length - 1][i])
                max = sum[length - 1][i];
        }

        return max;
    }


    public static void main(String[] args) {
        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

}

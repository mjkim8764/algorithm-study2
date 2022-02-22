package week3;

/*
    Week3.Prob03 : 타겟넘버
    url : https://programmers.co.kr/learn/courses/30/lessons/43165
 */

public class Prob03 {
    public static void dfs(int sum, int[] numbers, int depth, int target, int[] result) {
        if(depth == 0) {
            if(sum == target)
                result[0]++;
            return;
        }
        else {
            dfs(sum + numbers[numbers.length - depth], numbers, depth - 1, target, result);
            dfs(sum - numbers[numbers.length - depth], numbers, depth - 1, target, result);
        }
    }

    public static void solution(int[] numbers, int target) {
        int depth = numbers.length;
        int[] result = new int[] {0};

        dfs(0, numbers, depth, target, result);
        System.out.println(result[0]);

    }

    public static void main(String[] args) {
        int[] numbers1 = new int[] {1, 1, 1, 1, 1};
        int target1 = 3;

        int[] numbers2 = new int[] {4, 1, 2, 1};
        int target2 = 4;

        solution(numbers1, target1);
        solution(numbers2, target2);

    }
}

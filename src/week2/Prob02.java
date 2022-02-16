package week2;

/*

Incomplete

*/




import java.util.HashSet;

public class Prob02 {
    static HashSet<Integer> numbersSet = new HashSet<>();

    public static int solution(String numbers) {
        int answer = 0;

        permutation(numbers, "");
        return answer;
    }

    public static void permutation(String remain, String current){
        if(!remain.equals("")) {
            numbersSet.add(Integer.valueOf(remain));
        }
    }

    public static boolean isPrime(int number){
        return false;
    }

    public static void main(String[] args) {
        String numbers1 = "17";
        String numbers2 = "011";
        String numbers3 = "317";

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));
    }

}
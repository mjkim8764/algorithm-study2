package week2;

/*
    Week2.Prob02 : 소수 찾기
    url : https://programmers.co.kr/learn/courses/30/lessons/42839
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Prob02 {

    public static int solution(String numbers){
        int answer = 0;
        int length = numbers.length();

        int[] intNumbers = new int[length];
        LinkedList<Integer> list = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int[] visited = new int[length];


        // string -> int
        for(int i=0; i<length; i++)
            intNumbers[i] = numbers.charAt(i) - 48;

        // DFS
        for(int depth=0; depth<length; depth++){
            DFS(depth, list, set, visited, length, intNumbers);
        }

        // 소수 판별
        Iterator<Integer> ir = set.iterator();
        while(ir.hasNext()) {
            int sum = ir.next();
            if(sum >= 2 && isPrime(sum)) {
                // System.out.println(sum);
                answer++;
            }
        }

        return answer;
    }

    // DFS
    public static void DFS(int depth, LinkedList<Integer> list, HashSet<Integer> set, int[] visited, int length, int[] intNumbers){
        if(depth == -1) {
            // 중복 방지를 위해 set에 저장
            set.add(makeSum(list));
        } else {
            for(int i=0; i<length; i++) {
                if(visited[i] != 1) {
                    list.add(intNumbers[i]);
                    visited[i] = 1;
                    DFS(depth - 1, list, set, visited, length, intNumbers);
                    visited[i] = 0;
                    list.removeLast();
                }
            }
        }
    }


    // list에 저장된 숫자들로 sum을 구함
    public static int makeSum(LinkedList<Integer> list) {
        int sum = 0;
        int pow = 0;

        Iterator<Integer> ir = list.listIterator();
        while (ir.hasNext())
            sum += ir.next() * Math.pow(10, pow++);

        return sum;
    }


    // 소수 판별
    public static boolean isPrime(int sum){
        for(int i=2; i<=(int)(Math.sqrt(sum)); i++) {
            if(sum % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        //String numbers1 = "17";
        //String numbers2 = "011";
        String numbers3 = "317";

        //System.out.println(solution(numbers1));
        //System.out.println(solution(numbers2));
        System.out.println(solution(numbers3));
    }

}
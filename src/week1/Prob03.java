package week1;

/*
    week1.Prob03 :  주식가격
    url : https://programmers.co.kr/learn/courses/30/lessons/42584
 */

import java.util.ArrayList;
import java.util.Stack;

public class Prob03 {
    public static void solution(int[] prices) {
        ArrayList<Prob03Stock> stocks = new ArrayList<>();
        Stack<Prob03Stock> stack = new Stack<>();
        int[] answer = new int[prices.length];

        //ArrayList에 초기값 입력, 마지막 time은 0
        for (int i = 0; i < prices.length; i++) {
            if (i != prices.length - 1)
                stocks.add(new Prob03Stock(prices[i], 1, i));
            else
                stocks.add(new Prob03Stock(prices[i], 0, i));
        }

        //stack에 초기값 push
        stack.push(stocks.get(0));

        for (int i = 1; i < prices.length; i++) {
            while (prices[i] < stack.peek().getPrice()) {
                // 1. prices값이 peek보다 작으면 time 기록 후 pop
                // 2. 다음 peek의 time 증가
                int tempTime = stack.peek().getTime();
                answer[stack.peek().getcount()] = tempTime;
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().setTime(stack.peek().getTime() + tempTime);
                } else { break; }
            }
            stack.push(stocks.get(i));
        }

        //stack에 남아 있는 time 기록
        int times = 0;
        while(!stack.isEmpty()) {
            times += stack.peek().getTime();
            answer[stack.peek().getcount()] = times;
            stack.pop();
        }

        for(int i=0; i< prices.length; i++) {
            System.out.print(answer[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] prices1 = new int[] {1, 2, 3, 2, 1};
        int[] prices2 = new int[] {1, 2, 3, 2, 3};
        solution(prices1);
        solution(prices2);
    }
}
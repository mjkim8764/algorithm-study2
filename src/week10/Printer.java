package week10;

/*
    Week10.01 : 프린터
    url : https://programmers.co.kr/learn/courses/30/lessons/42587
*/

import java.util.*;

public class Printer {

    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Document> dQueue = new LinkedList<>();

        /**
         * Queue 에 먼저 값들을 넣음.
         */
        for(int i = 0; i < priorities.length; i++)
            dQueue.add(new Document(i, priorities[i]));

        while(!dQueue.isEmpty()) {

            /**
             * 1. 인쇄 대기목록 (Queue) 의 가장 앞에 있는 문서를 꺼냄.
             */
            Document currentDocument = dQueue.poll();
            boolean isPrintable = true;

            /**
             * 2. 나머지 인쇄 대기목록에서 꺼낸 문서보다 중요도가 높은 문서가 존재하면
             * 다시 대기목록의 마지막 (Queue) 에 넣음.
             */
            Iterator<Document> ir = dQueue.iterator();
            while (ir.hasNext()) {
                Document nextDocument = ir.next();
                if (currentDocument.priority < nextDocument.priority) {
                    dQueue.add(currentDocument);
                    isPrintable = false;
                    break;
                }
            }


            /**
             *  3. 그렇지 않으면 (isPrintable = true) 인쇄함
             */
            if (isPrintable) {
                answer++;
                if(currentDocument.index == location)
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] priorities1 = new int[] {2, 1, 3, 2};
        int location1 = 2;

        int[] priorities2 = new int[] {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(solution(priorities1, location1));
        System.out.println(solution(priorities2, location2));
    }
}

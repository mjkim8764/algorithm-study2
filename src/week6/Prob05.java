package week6;

/*
    Week6.Prob05 : 단어 변환
    url : https://programmers.co.kr/learn/courses/30/lessons/43163
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prob05 {

    // target이 words 안에 있는지 확인
    public static boolean existTarget(String target, String[] words){
        for (String word : words) {
            if (word.equals(target))
                return true;
        }
        return false;
    }

    // 변환할 수 있는지(다른 문자가 하나만 있는지) 확인
    public static boolean isConvertable(String current, String next){
        int length = current.length();
        int cnt = 0;
        for(int i=0; i<length; i++) {
            if(current.charAt(i) != next.charAt(i)) {
                cnt++;
            }
        }

        return (cnt == 1);
    }

    public static int solution(String begin, String target, String[] words){

        // target이 words에 없으면 0 반환
        if(!existTarget(target, words)){
            return 0;
        }

        int wordsSize = words.length;

        boolean[] visited = new boolean[wordsSize];

        // bfs 이용, queue의 첫 값으로 begin 넣음
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        int level = 0;

        while(!queue.isEmpty()) {

            ArrayList<String> currentLevelWords = new ArrayList<>();

            int queueSize = queue.size();
            for(int i=1; i<=queueSize; i++) {
                currentLevelWords.add(queue.poll());
            }

            // 현재 level에 있는 단어들에 대해서 검색
            for (String currentLevelWord : currentLevelWords) {
                for (int i=0; i<wordsSize; i++) {

                    // 방문한 적이 없으며, 변환 가능한 단어를 찾음
                    if (isConvertable(currentLevelWord, words[i]) && !visited[i]) {

                        // 변환 가능한 단어가 target일 경우 종료
                        if(words[i].equals(target)) {
                            return level + 1;
                        }

                        else {
                            queue.add(words[i]);
                            visited[i] = true;
                        }
                    }
                }
            }

            level++;
        }

        // queue가 전부 빌 때까지 수행되었다는 것은 target까지 변환할 수 없다는 것을 의미
        return 0;

    }


    public static void main(String[] args) {
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        String begin3 = "hit";
        String target3 = "hot";
        String[] words3 = {"hit", "hot", "lot"};

        System.out.println(solution(begin1, target1, words1));
        System.out.println(solution(begin2, target2, words2));
        System.out.println(solution(begin3, target3, words3));

    }

}

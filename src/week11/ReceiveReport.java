package week11;

/*
    Week11.03 : 신고 결과 받기
    url : https://programmers.co.kr/learn/courses/30/lessons/92334
*/

import java.util.HashMap;

public class ReceiveReport {

    private static void solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> listMap = new HashMap<>();
        boolean[][] reported = new boolean[id_list.length][id_list.length];
        int[] reportedCount = new int[id_list.length];
        int[] result = new int[id_list.length];

        // 회원 정보를 map 에 넣음.
        for(int i = 0; i < id_list.length; i++) {
            listMap.put(id_list[i], i);
        }

        // report 내용을 보고 reported 가 false 면 true 로 바꿔주고 해당 회원의 신고횟수 누적
        // ex) reported[0][1] : 0번째 회원이 1번째 회원을 신고하였는지 여부
        for(int i = 0; i < report.length; i++) {
            String[] reportInfo = report[i].split(" ");
            int x = listMap.get(reportInfo[0]);
            int y = listMap.get(reportInfo[1]);
            if(!reported[x][y]) {
                reported[x][y] = true;
                reportedCount[y]++;
            }
        }

        // i 번째 사람이 j 번째 사람을 신고한 이력이 있고
        // 그 사람이 총 신고당한 횟수가 k 이상이면 메일 수 카운트
        for(int i = 0; i < id_list.length; i++) {
            for(int j = 0; j < id_list.length; j++) {
                if( reported[i][j] && reportedCount[j] >= k) {
                    result[i]++;
                }
            }
        }

        for(int i = 0; i < id_list.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();

    }

    public static void main(String[] args) {
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k1 = 2;

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        solution(id_list1, report1, k1);
        solution(id_list2, report2, k2);

    }

}

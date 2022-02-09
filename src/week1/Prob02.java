package week1;

import java.util.LinkedList;
import java.util.Queue;

public class Prob02 {

    public static void solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        int bridgeWeight = 0;

        //대기하고 있는 트럭 큐, 다리 위에 있는 트럭 큐
        Queue<Prob02Truck> waits = new LinkedList<>();
        Queue<Prob02Truck> onBridges = new LinkedList<>();

        //대기하고 있는 트럭 입력
        for(int i=0; i< truck_weights.length; i++) {
            waits.add(new Prob02Truck(truck_weights[i], 0));
        }

        // 큐가 모두 빌 때까지
        while( !(waits.isEmpty() && onBridges.isEmpty()) ){

            // 1초 경과
            answer++;
            for(Prob02Truck truck : onBridges) {
                truck.setTime(truck.getTime() + 1);
            }

            // 다리위의 마지막 차의 경과시간이 끝나면 큐에서 꺼냄
            if(!onBridges.isEmpty()) {
                if(onBridges.peek().getTime() == bridge_length) {
                    bridgeWeight -= onBridges.peek().getWeight();
                    onBridges.poll();
                }
            }

            // 대기하고 있는 차가 들어와도 되면 대기큐에서 꺼내 다리큐로 넣어줌
            if(!waits.isEmpty()) {
                if(bridgeWeight + waits.peek().getWeight() <= weight) {
                    bridgeWeight += waits.peek().getWeight();
                    onBridges.add(waits.poll());
                }
            }
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {
        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = new int[] {7, 4, 5, 6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = new int[] {10};

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        solution(bridge_length1, weight1, truck_weights1);
        solution(bridge_length2, weight2, truck_weights2);
        solution(bridge_length3, weight3, truck_weights3);
    }
}
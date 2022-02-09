package week1;

/*
    week1.Prob02 :  다리를 지나는 트럭
    url : https://programmers.co.kr/learn/courses/30/lessons/42583
 */

public class Prob02Truck {
    int weight;
    int time;

    public Prob02Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time){
        this.time = time;
    }
}

package week1;

/*
    week1.Prob03 :  주식가격
    url : https://programmers.co.kr/learn/courses/30/lessons/42584
 */

public class Prob03Stock {
    private int price;
    private int time;
    private int index;

    Prob03Stock(int price, int time, int index){
        this.price = price;
        this.time = time;
        this.index = index;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getTime(){
        return this.time;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getIndex(){
        return this.index;
    }

    public void setIndex(int index){
        this.price = index;
    }
}
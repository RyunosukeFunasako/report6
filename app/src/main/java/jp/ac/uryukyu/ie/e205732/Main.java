package jp.ac.uryukyu.ie.e205732;

public class Main {
    public static void main(String[] args) {
        HitAndBlow Hit = new HitAndBlow();
        Hit.direction();

        int[] answer;
        answer = Hit.answer();
        int[] input;
        input = Hit.input();
        
        Hit.judge(answer, input);
    }
}

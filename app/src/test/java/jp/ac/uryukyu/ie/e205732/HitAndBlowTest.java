package jp.ac.uryukyu.ie.e205732;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HitAndBlowTest {
    @Test
    void judgeTest(){
        int[] answer = new int[4];
        answer[0] = 1;
        answer[1] = 2;
        answer[2] = 3;
        answer[3] = 4;

        int[] input = new int[4];
        input[0] = 1;
        input[1] = 2;
        input[2] = 4;
        input[3] = 3;

        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < input.length; j++){
                if(i == j && answer[i] == input[j]){
                    HitAndBlow.eat++;
                }else if(answer[i] == input[j]){
                    HitAndBlow.bite++;
                }
            }
        }
        assertEquals(HitAndBlow.eat, HitAndBlow.bite);
    }
}

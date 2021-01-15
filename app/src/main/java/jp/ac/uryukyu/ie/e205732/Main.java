package jp.ac.uryukyu.ie.e205732;

/**
 * HitAndBlowを動かすためのMainクラス
 */
public class Main{
    /**
     * HitAndBlowクラスの各種メソッドを呼び出す
     * ゲーム終了判定等のループ処理
     * @param args
     */
    public static void main(String[] args){
        HitAndBlow Hit = new HitAndBlow();
        Hit.direction();
        int[] answer;
        answer = Hit.answer();

        while(true){
            int[] input;
            input = Hit.input();
            Hit.judge(answer, input);
            HitAndBlow.turn++;
            if(HitAndBlow.eat < 4){
                HitAndBlow.eat = 0;
                HitAndBlow.bite = 0;
            }else if(HitAndBlow.eat == 4){
                System.out.println("\n"
                + "~~~congratulations~~~\n"
                + "4eat達成！ゲーム終了です。\n");
                break;
            }
        }
    }
}

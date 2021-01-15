package jp.ac.uryukyu.ie.e205732;

public class Main{
    public static void main(String[] args){
        //HitAndblowインスタンス生成
        HitAndBlow Hit = new HitAndBlow();
        //説明文出力
        Hit.direction();
        //judgeメソッドの引数として使えるようにanswerメソッドを呼び出す
        int[] answer;
        answer = Hit.answer();

        while(true){
            //judgeメソッドの引数として使えるようにinputメソッドを呼び出す
            int[] input;
            input = Hit.input();
            //judgeメソッドを呼び出し、eat数を把握できるようにする
            Hit.judge(answer, input);
            //ループ処理1回ごとにターンのカウンターを1増やす
            HitAndBlow.turn++;
            //1ターンごとに判定結果をリセット
            if(HitAndBlow.eat < 4){
                HitAndBlow.eat = 0;
                HitAndBlow.bite = 0;
            }
            //ゲーム終了判定
            else if(HitAndBlow.eat == 4){
                System.out.println("\n"
                + "~~~congratulations~~~\n"
                + "4eat達成！ゲーム終了です。\n");
                break;
            }
        }
    }
}

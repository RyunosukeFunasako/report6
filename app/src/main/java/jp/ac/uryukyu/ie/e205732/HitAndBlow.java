package jp.ac.uryukyu.ie.e205732;

public class HitAndBlow {
    //ゲーム説明をする出力するメソッド
    public static void direction(){
        System.out.println("Hit&Blowを開始します。\n"
        + "0~9の重複のない4桁の数字を当ててもらいます。\n"
        + "入力した数字が同じ桁の数字であった場合 eat、\n"
        + "入力した数字が違う桁の数字であった場合 bite とカウントします。\n"
        + "全ての桁が一致すればゲーム終了です。");
    }
}
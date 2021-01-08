package jp.ac.uryukyu.ie.e205732;

import java.util.ArrayList;
import java.util.Collections;

public class HitAndBlow {
    //ゲーム説明をする出力するメソッド
    public static void direction(){
        System.out.println("Hit&Blowを開始します。\n"
        + "0~9の重複のない4桁の数字を当ててもらいます。\n"
        + "入力した数字が同じ桁の数字であった場合 eat、\n"
        + "入力した数字が違う桁の数字であった場合 bite とカウントします。\n"
        + "全ての桁が一致すればゲーム終了です。");
    }

    //答えの配列を用意するメソッド
    public static void answer(){
        //答えとなる4つの空の配列answerを用意
        int[] answer = new int[4];
        //1~9までの数字を格納する別の配列listを用意
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= 9; i++){
            list.add(i);
        }
        //list配列の数字をシャッフル
        Collections.shuffle(list);
        //list配列から4つ取り出しanswer配列に入れる
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
            //動作確認のため出力させる
            System.out.println(answer[i]);
        }
    }
}
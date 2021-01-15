package jp.ac.uryukyu.ie.e205732;

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitAndBlow {
    //クラス変数の用意
    static int eat = 0;
    static int bite = 0;
    static int turn = 1;
    //ゲーム説明を出力するメソッド
    public void direction(){
        System.out.println("Hit&Blowを開始します。\n"
        + "0~9の重複のない4桁の数字を当ててもらいます。\n"
        + "入力した数字が同じ桁の数字であった場合 eat、\n"
        + "入力した数字が違う桁の数字であった場合 bite とカウントします。\n"
        + "全ての桁が一致すればゲーム終了です。");
    }

    //答えの配列を用意するメソッド
    public int[] answer(){
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
        return answer;
    }

    //Playerが入力した数字を読み込むメソッド
    public int[] input(){
        //入力する4つの空の配列inputを用意
        int[] input = new int[4];
        //コンソール入力を可能にする
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        //ターン数を表示
        System.out.println("\n" + turn + "ターン目");
        for(int j = 0; j < input.length; j++){
            int a = 0;
            System.out.print((j + 1) + "つ目の数字:");
            try{
                //入力されたものを数値に変換
                input[j] = Integer.parseInt(br.readLine());
                a = input[j];
                //数字以外の文字の入力をされた場合
            }catch(NumberFormatException e){
                System.out.println("数字を入力してください。");
                j--;
                //形式が間違っていた場合
            }catch(IOException e){
                System.out.println("もう一度入力してください。");
                j--;
                //例外があってもなくても必ず実行する処理
            }finally{
                //入力された数字が範囲外だった場合
                if(a >= 10){
                    System.out.println("0~9の数字を入力してください。");
                    j--;
                }
                //入力された数字が重複していた場合
                for(int k = j - 1; k >= 0; k--){
                    if(input[j] == input[k]){
                        System.out.println("重複しないように入力してください。");
                        j--;
                    }
                }
            }
        }
        return input;
    }
    
    //判定するメソッド
    public void judge(int[] answer, int[] input) {
        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < input.length; j++) {
                //eatの条件
                if(i == j && answer[i] == input[j]) {
                    eat++;
                    //biteの条件
                }else if(answer[i] == input[j]){
                    bite++;
                }
            }
        }
        //eat,biteのカウンター表示
        System.out.println(eat + "eat" + bite + "bite");
    }
}
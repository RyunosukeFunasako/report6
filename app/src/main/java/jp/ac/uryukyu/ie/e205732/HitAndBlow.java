package jp.ac.uryukyu.ie.e205732;

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HitAndBlowを実装する
 * 説明文を出力する、答えを用意する、入力を読み込む、判定するメソッドを用意した
 */
public class HitAndBlow{
    /**
     * クラス変数の用意
     */
    static int eat = 0;
    static int bite = 0;
    static int turn = 1;
    static int answerSize = 3;

    /**
     * ゲーム説明を出力するメソッド
     */
    public void direction(){
        System.out.println("\n"
        + "---------------Hit&Blow---------------\n"
        + "・ 0~9の重複のない" + answerSize +"桁の数字を当ててもらいます。\n"
        + "・ 入力した数字が同じ桁の数字であった場合 eat、\n"
        + "・ 入力した数字が違う桁の数字であった場合 bite とカウントします。\n"
        + "・ 全ての桁が一致すればゲーム終了です。");
    }

    /**
     * 答えの配列を用意するメソッド
     * 答えとなる4つの空の配列answerを用意
     * 0~9が入った配列listを用意
     * list配列をシャッフルし、0~3番目を配列answerに加える
     * @return 答えの配列answer
     */
    public int[] answer(){
        int[] answer = new int[answerSize];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= 9; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    /**
     * Playerが入力した数字を読み込むメソッド
     * 入力する4つの空の配列inputを用意
     * コンソール入力を可能にする
     * ターン数を表示させる
     * 入力されたものを数値に変換
     * 各種例外処理
     * @return 入力の配列input
     */
    public int[] input(){
        int[] input = new int[answerSize];
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("\n" + "***" + turn + "ターン目***");
        for(int j = 0; j < input.length; j++){
            int a = 0;
            System.out.print((j + 1) + "つ目の数字:");
            try{
                input[j] = Integer.parseInt(br.readLine());
                a = input[j];
            }catch(NumberFormatException e){
                System.out.println("数字を入力してください。");
                j--;
            }catch(IOException e){
                System.out.println("もう一度入力してください。");
                j--;
            }finally{
                if(a >= 10){
                    System.out.println("0~9の数字を入力してください。");
                    j--;
                }
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
    
    /**
     * 判定するメソッド
     * eat,biteの条件
     * eat,biteの数を表示させる
     * @param answer 答えの配列answer
     * @param input 入力の配列input
     */
    public void judge(int[] answer, int[] input){
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < input.length; j++){
                if(i == j && answer[i] == input[j]){
                    eat++;
                }else if(answer[i] == input[j]){
                    bite++;
                }
            }
        }
        System.out.println("\n"
        + "===result===\n" 
        + eat + "eat" + bite + "bite");
    }
}
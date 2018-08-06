/*
  演習2-3 ジャンケンプログラムに以下の2つの改良を加えることを考えます。Work2-2で完成させたジャンケンプログラムのリストを
          見ながら、どのように直したらよいか考えてください。
          １．「プレイヤー１」のような味気のない名前ではなく、「村田さん」のように、それぞれ好きな名前を表示できるようにする
          ２．プレイヤーの人数を2人～5人の間で自由に決められるようにする
          ３．プレイヤーの手の出し方を、すべてランダムではなくプレイヤーごとに変えられるようにする
  演習日  7月9日
  製作者  玉利仁美
 */

package work2_3;

import java.util.Scanner;

//問題文の通りSimpleJankenクラスを作成する
public class SimpleJanken_1 {
    //グーの時のIDを定数として宣言
    public static final int STONE = 0;
    //チョキの時のIDを定数として宣言
    public static final int SCISSORS = 1;
    //パーの時のIDを定数として宣言
    public static final int PAPER = 2;

    /**
     * メインメソッド
     * @author 小森裕介
     * @param args コマンドライン引数
     */
    //メインメソッド
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int howManyPlayer = 0;

        do {
            System.out.println("プレイヤーの数は?：");
            howManyPlayer = stdIn.nextInt();
        } while (howManyPlayer <= 1 && howManyPlayer >= 5);

        //ジャンケンの手をランダムに取得するための変数を初期化しておく
        double randomNum = 0;
        //Player1の手を保持するための変数を初期化しておく
        int player1Hand = 0;
        //Player2の手を保持するための変数を初期化しておく
        int player2Hand = 0;
        //Player1の勝った回数を保持するための変数を初期化しておく
        int player1WinCount = 0;
        //Player2の勝った回数を保持するための変数を初期化しておく
        int player2WinCount = 0;
        //Player1の人の名前を保持するための変数
        String player1Name;
        //Player2の人の名前を保持するための変数
        String player2Name;

        System.out.println("プレイヤー1の名前は?：");
        player1Name = stdIn.next();
        System.out.println("プレイヤー2の名前は?：");
        player2Name = stdIn.next();

        if (howManyPlayer == 5) {
            int player3Hand = 0;
            int player4Hand = 0;
            int player5Hand = 0;

            int player3WinCount = 0;
            int player4WinCount = 0;
            int player5WinCount = 0;

            String player3Name;
            String player4Name;
            String player5Name;

            System.out.println("プレイヤー3の名前は?：");
            player3Name = stdIn.next();
            System.out.println("プレイヤー4の名前は?：");
            player4Name = stdIn.next();
            System.out.println("プレイヤー5の名前は?：");
            player5Name = stdIn.next();

        } else if (howManyPlayer == 4) {
            int player3Hand = 0;
            int player4Hand = 0;

            int player3WinCount = 0;
            int player4WinCount = 0;

            String player3Name;
            String player4Name;

            System.out.println("プレイヤー3の名前は?：");
            player3Name = stdIn.next();
            System.out.println("プレイヤー4の名前は?：");
            player4Name = stdIn.next();

        } else if (howManyPlayer == 3) {
            int player3Hand = 0;

            int player3WinCount = 0;

            String player3Name;

            System.out.println("プレイヤー3の名前は?：");
            player3Name = stdIn.next();
        }

        if (howManyPlayer == 2) {

        }

        //ジャンケンが開始したことを明示する
        System.out.println("【ジャンケン開始】\n");

        //三回勝負なので3回繰り返す
        for (int cnt = 0; cnt < 3; cnt++) {
            //ランダムな手の値を取得するために3倍して3以上にならないよう調整する
            randomNum = Math.random() * 3;
            //ランダムな手の値が1未満ならPlayer1の出す手はグーにする
            if (randomNum < 1) {
                //プレイヤー1の手はグー
                player1Hand = STONE;
                //プレイヤー1がグーだったことを明示する
                System.out.print("グー");
                //ランダムで出た値が1以上2未満なら出す手はチョキになる
            } else if (randomNum < 2) {
                //プレイヤー1の手はチョキ
                player1Hand = SCISSORS;
                //プレイヤー1がチョキだったことを明示する
                System.out.print("チョキ");
                //ランダムで出た値が2以上3未満なら出す手はパーになる
            } else if (randomNum < 3) {
                //プレイヤー1の手はチョキ
                player1Hand = PAPER;
                //プレイヤー1がパーだったことを明示する
                System.out.print("パー");
            }
            //プレイヤー2の手をランダムで決めるためもう一度0から3未満で値を取得する
            randomNum = Math.random() * 3;
            //ランダムな手の値が1未満ならPlayer2の出す手はグーになる
            if (randomNum < 1) {
                //プレイヤー2の出す手はグーになる
                player2Hand = STONE;
                //プレイヤー2の出した手がグーであったことを明示する
                System.out.print("グー");
                //ランダムで出た値が1以上2未満なら出す手はチョキになる
            } else if (randomNum < 2) {
                //ランダムで出た値が1以上2未満なら出す手はチョキになる
                player2Hand = SCISSORS;
                //プレイヤ-2の出した手がチョキであったことを明示する
                System.out.print("チョキ");
                //2以上3未満の場合は値はパーになる
            } else if (randomNum < 3) {
                //プレイヤー2の手はパーになる
                player2Hand = PAPER;
                //プレイヤー2の手がパーであったことを明示する
                System.out.print("パー");
            }

            //プレイヤー1が勝った時の条件の時
            if ((player1Hand == STONE && player2Hand == SCISSORS)
                    || (player1Hand == SCISSORS && player2Hand == PAPER)
                    || (player1Hand == PAPER && player2Hand == STONE)) {
                //プレイヤー1の勝利回数に1加える
                player1WinCount++;
                //プレイヤー1が勝ったことを明示する
                System.out.println("\nプレイヤー1が勝ちました！！\n");
                //プレイヤー2が勝った時の条件の時
            } else if ((player1Hand == STONE && player2Hand == PAPER)
                    || (player1Hand == SCISSORS && player2Hand == STONE)
                    || (player1Hand == PAPER && player2Hand == SCISSORS)) {
                //プレイヤー2の勝利回数に1を加える
                player2WinCount++;
                //プレイヤー2が勝ったことを明示する
                System.out.println("\nプレイヤー2が勝ちました！！\n");
                //それ以外は引き分け扱いになる
            } else {
                //引き分けであることを明示する
                System.out.println("\n引き分けです！\n");
            }
        }

        //3回繰り返した後ジャンケンの結果を表示する
        System.out.println("【ジャンケン終了】\n");

        //プレイヤー1の勝利回数がプレイヤー2より多いとき
        if (player1WinCount > player2WinCount) {
            //対戦結果の結果表示とプレイヤー1の勝利を明示する
            System.out.println(player2WinCount + "対" + player2WinCount + "でプレイヤー1の勝ちです、");
            //プレイヤー2の勝利回数がプレイヤー1より多いとき
        } else if (player1WinCount < player2WinCount) {
            //対戦結果の結果表示とプレイヤー２の勝利数を明示する
            System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー2の勝ちです！");
            //それ以外の時は引き分けなので
        } else if (player1WinCount == player2WinCount) {
            //対戦結果を表示して引き分けであることを明示する
            System.out.println(player1WinCount + "対" + player2WinCount + "で引き分けです！\n");
        }

    }
}
/*
  演習2-3 ジャンケンプログラムに以下の2つの改良を加えることを考えます。Work2-2で完成させたジャンケンプログラムのリストを
          見ながら、どのように直したらよいか考えてください。
          １．「プレイヤー１」のような味気のない名前ではなく、「村田さん」のように、それぞれ好きな名前を表示できるようにする
          ２．プレイヤーの人数を2人～5人の間で自由に決められるようにする
          ３．プレイヤーの手の出し方を、すべてランダムではなくプレイヤーごとに変えられるようにする
  演習日  8月8日
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
     * @author 玉利仁美
     * @param args コマンドライン引数
     */
    //メインメソッド
    public static void main(String[] args) {
        //ユーザが入力できるようにスキャナークラスを宣言する
        Scanner stdIn = new Scanner(System.in);
        //何人でジャンケンをやるかを表す変数を宣言
        int howManyPlayer = 0;

        //プレイヤー数が既定の1から5人までの人数を入力するまで繰り返す
        do {
            //プレイヤー数を求める文言を表示する
            System.out.println("プレイヤーの数は?(2～5人まで)：");
            //何人でプレイするかをユーザによって入力させる
            howManyPlayer = stdIn.nextInt();
        } while (howManyPlayer <= 2 && howManyPlayer >= 5);

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
        //プレイヤー1が手動かランダムかを判定する変数
        int player1UserOrCQU = -1;
        //プレイヤー2が手動かランダムかを判定する変数
        int player2UserOrCQU = -1;

        //プレイヤー3の手を最初はグーにしておく
        int player3Hand = 0;
        //プレイヤー4の手を最初はグーにしておく
        int player4Hand = 0;
        //プレイヤー5の手を最初はグーにしておく
        int player5Hand = 0;

        //プレイヤー3の名前を初期化して宣言
        String player3Name = "";
        //プレイヤー4の名前を初期化して宣言
        String player4Name = "";
        //プレイヤー5の名前を初期化して宣言
        String player5Name = "";

        //今後の判定で不正値にならないよう2で初期化してCPUかどうかを判定する変数を宣言
        int player3UserOrCQU = -1;
        //今後の判定で不正値にならないよう2で初期化してCPUかどうかを判定する変数を宣言
        int player4UserOrCQU = -1;
        //今後の判定で不正値にならないよう2で初期化してCPUかどうかを判定する変数を宣言
        int player5UserOrCQU = -1;

        //プレイヤー1の名前を任意に決められるようにする
        System.out.println("プレイヤー1の名前は?：");
        //ユーザの入力した名前をプレイヤー1の名前用変数に取っておく
        player1Name = stdIn.next();
        //プレイヤー2の名前を任意に決められるようにする
        System.out.println("プレイヤー2の名前は?：");
        //ユーザの入力した名前をプレイヤー2の名前用変数に取っておく
        player2Name = stdIn.next();

        //プレイヤーが5人の時
        if (howManyPlayer == 5) {

            //プレイヤー3の名前の入力を促す
            System.out.println("プレイヤー3の名前は?：");
            //プレイヤー3の名前をユーザ入力から取得する
            player3Name = stdIn.next();
            //プレイヤー4の名前の入力を促す
            System.out.println("プレイヤー4の名前は?：");
            //プレイヤー4の名前をユーザ入力から取得する
            player4Name = stdIn.next();
            //プレイヤー5の名前の入力を促す
            System.out.println("プレイヤー5の名前は?：");
            //プレイヤー5の名前をユーザ入力から取得する
            player5Name = stdIn.next();

            //プレイヤー1をCPUにするかどうかの判定を求める
            System.out.println(player1Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player1UserOrCQU = stdIn.nextInt();
            //プレイヤー2をCPUにするかどうかの判定を求める
            System.out.println(player2Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player2UserOrCQU = stdIn.nextInt();
            //プレイヤー3をCPUにするかどうかの判定を求める
            System.out.println(player3Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player3UserOrCQU = stdIn.nextInt();
            //プレイヤー4をCPUにするかどうかの判定を求める
            System.out.println(player4Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player4UserOrCQU = stdIn.nextInt();
            //プレイヤー5をCPUにするかどうかの判定を求める
            System.out.println(player5Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player5UserOrCQU = stdIn.nextInt();

        } else if (howManyPlayer == 4) {

            //プレイヤー3の名前の入力を促す
            System.out.println("プレイヤー3の名前は?：");
            //プレイヤー3の名前をユーザ入力から取得する
            player3Name = stdIn.next();
            //プレイヤー4の名前の入力を促す
            System.out.println("プレイヤー4の名前は?：");
            //プレイヤー4の名前をユーザ入力から取得する
            player4Name = stdIn.next();

            //プレイヤー1をCPUにするかどうかの判定を求める
            System.out.println(player1Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player1UserOrCQU = stdIn.nextInt();
            //プレイヤー2をCPUにするかどうかの判定を求める
            System.out.println(player2Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player2UserOrCQU = stdIn.nextInt();
            //プレイヤー3をCPUにするかどうかの判定を求める
            System.out.println(player3Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player3UserOrCQU = stdIn.nextInt();
            //プレイヤー4をCPUにするかどうかの判定を求める
            System.out.println(player4Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player4UserOrCQU = stdIn.nextInt();

        } else if (howManyPlayer == 3) {
            //プレイヤー3の名前の入力を促す
            System.out.println("プレイヤー3の名前は?：");
            //プレイヤー3の名前をユーザ入力から取得する
            player3Name = stdIn.next();

            //プレイヤー1をCPUにするかどうかの判定を求める
            System.out.println(player1Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player1UserOrCQU = stdIn.nextInt();
            //プレイヤー2をCPUにするかどうかの判定を求める
            System.out.println(player2Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player2UserOrCQU = stdIn.nextInt();
            //プレイヤー3をCPUにするかどうかの判定を求める
            System.out.println(player3Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player3UserOrCQU = stdIn.nextInt();
        } else if (howManyPlayer == 2) {
            //プレイヤー1をCPUにするかどうかの判定を求める
            System.out.println(player1Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player1UserOrCQU = stdIn.nextInt();
            //プレイヤー2をCPUにするかどうかの判定を求める
            System.out.println(player2Name + "をCPUにしますか？はい…1/いいえ…0");
            //ユーザ入力によってCPUにするかどうかを判定する
            player2UserOrCQU = stdIn.nextInt();
        }

        //ジャンケンが開始したことを明示する
        System.out.println("【ジャンケン開始】\n");

        //三回勝負なので3回繰り返す
        for (int cnt = 0; cnt < 3; cnt++) {

            //プレイヤー1がCPUの時
            if (player1UserOrCQU == 1) {
                //ランダムな手の値を取得するために3倍して3以上にならないよう調整する
                randomNum = Math.random() * 3;
                //ランダムな手の値が1未満ならPlayer1の出す手はグーにする
                if (randomNum < 1) {
                    //プレイヤー1の手はグー
                    player1Hand = STONE;
                    //ランダムで出た値が1以上2未満なら出す手はチョキになる
                } else if (randomNum < 2) {
                    //プレイヤー1の手はチョキ
                    player1Hand = SCISSORS;
                    //ランダムで出た値が2以上3未満なら出す手はパーになる
                } else if (randomNum < 3) {
                    //プレイヤー1の手はチョキ
                    player1Hand = PAPER;
                }
                //プレイヤー1がユーザ入力の時
            } else if (player1UserOrCQU == 0) {
                //プレイヤーの手が想定外の数字を入力している間は繰り返す
                do {
                    //プレイヤー1の手の入力を促す
                    System.out.println("プレイヤー1の手は?：");
                    //ユーザ入力からプレイヤー1の手を取得する
                    player1Hand = stdIn.nextInt();
                } while (player1Hand < 0 && player1Hand > 2);
            }

            //プレイヤー2がCPUの時
            if (player2UserOrCQU == 1) {
                //ランダムな手の値を取得するために3倍して3以上にならないよう調整する
                randomNum = Math.random() * 3;
                //ランダムな手の値が1未満ならPlayer1の出す手はグーにする
                if (randomNum < 1) {
                    //プレイヤー1の手はグー
                    player2Hand = STONE;
                    //ランダムで出た値が1以上2未満なら出す手はチョキになる
                } else if (randomNum < 2) {
                    //プレイヤー1の手はチョキ
                    player2Hand = SCISSORS;
                    //ランダムで出た値が2以上3未満なら出す手はパーになる
                } else if (randomNum < 3) {
                    //プレイヤー1の手はチョキ
                    player2Hand = PAPER;
                }
                //プレイヤー2がユーザ入力の時
            } else if (player2UserOrCQU == 0) {
                //プレイヤーの手が想定外の数字を入力している間は繰り返す
                do {
                    //プレイヤー2の手の入力を促す
                    System.out.println("プレイヤー2の手は?：");
                    player2Hand = stdIn.nextInt();
                    //ユーザ入力からプレイヤー2の手を取得する
                } while (player2Hand < 0 && player2Hand > 2);
            }
            //プレイヤー3がCPUの時
            if (player3UserOrCQU == 1) {
                //ランダムな手の値を取得するために3倍して3以上にならないよう調整する
                randomNum = Math.random() * 3;
                //ランダムな手の値が1未満ならPlayer1の出す手はグーにする
                if (randomNum < 1) {
                    //プレイヤー1の手はグー
                    player3Hand = STONE;
                    //ランダムで出た値が1以上2未満なら出す手はチョキになる
                } else if (randomNum < 2) {
                    //プレイヤー1の手はチョキ
                    player3Hand = SCISSORS;
                    //ランダムで出た値が2以上3未満なら出す手はパーになる
                } else if (randomNum < 3) {
                    //プレイヤー1の手はチョキ
                    player3Hand = PAPER;
                }
                //プレイヤー3がユーザ入力の時
            } else if (player3UserOrCQU == 0) {
                //プレイヤーの手が想定外の数字を入力している間は繰り返す
                do {
                    //プレイヤー3の手の入力を促す
                    System.out.println("プレイヤー3の手は?：");
                    //ユーザ入力からプレイヤー3の手を取得する
                    player3Hand = stdIn.nextInt();
                } while (player3Hand < 0 && player3Hand > 2);
            }
            //プレイヤー4がCPUの時
            if (player4UserOrCQU == 1) {
                //ランダムな手の値を取得するために3倍して3以上にならないよう調整する
                randomNum = Math.random() * 3;
                //ランダムな手の値が1未満ならPlayer1の出す手はグーにする
                if (randomNum < 1) {
                    //プレイヤー1の手はグー
                    player4Hand = STONE;
                    //ランダムで出た値が1以上2未満なら出す手はチョキになる
                } else if (randomNum < 2) {
                    //プレイヤー1の手はチョキ
                    player4Hand = SCISSORS;
                    //ランダムで出た値が2以上3未満なら出す手はパーになる
                } else if (randomNum < 3) {
                    //プレイヤー1の手はチョキ
                    player4Hand = PAPER;
                }
                //プレイヤー4がユーザ入力の時
            } else if (player4UserOrCQU == 0) {
                //プレイヤーの手が想定外の数字を入力している間は繰り返す
                do {
                    //プレイヤー4の手の入力を促す
                    System.out.println("プレイヤー4の手は?：");
                    //ユーザ入力からプレイヤー4の手を取得する
                    player4Hand = stdIn.nextInt();
                } while (player4Hand < 0 && player4Hand > 2);
            }
            //プレイヤー5がCPUの時
            if (player5UserOrCQU == 1) {
                //ランダムな手の値を取得するために3倍して3以上にならないよう調整する
                randomNum = Math.random() * 3;
                //ランダムな手の値が1未満ならPlayer1の出す手はグーにする
                if (randomNum < 1) {
                    //プレイヤー1の手はグー
                    player5Hand = STONE;

                    //ランダムで出た値が1以上2未満なら出す手はチョキになる
                } else if (randomNum < 2) {
                    //プレイヤー1の手はチョキ
                    player5Hand = SCISSORS;
                    //ランダムで出た値が2以上3未満なら出す手はパーになる
                } else if (randomNum < 3) {
                    //プレイヤー1の手はチョキ
                    player5Hand = PAPER;
                }
                //プレイヤー5がユーザ入力の時
            } else if (player5UserOrCQU == 0) {
                //プレイヤーの手が想定外の数字を入力している間は繰り返す
                do {
                    //プレイヤー5の手の入力を促す
                    System.out.println("プレイヤーの手は?：");
                    //ユーザ入力からプレイヤー5の手を取得する
                    player5Hand = stdIn.nextInt();
                } while (player5Hand < 0 && player5Hand > 2);
            }

            //プレイヤーが5人の時
            if (howManyPlayer == 5) {

                //プレイヤー1の手がグーだった時
                if (player1Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : グー");
                    //プレイヤー1の手がチョキだった時
                } else if (player1Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : チョキ");
                    //プレイヤー1の手がチョキだった時
                } else if (player1Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : パー");
                }
                //プレイヤー2の手がグーだった時
                if (player2Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player2Name + " : グー");
                    //プレイヤー2の手がチョキだった時
                } else if (player2Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : チョキ");
                    //プレイヤー2の手がパーだった時
                } else if (player2Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player2Name + " : パー");
                }
                //プレイヤー3の手がグーだった時
                if (player3Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : グー");
                    //プレイヤー3の手がチョキだった時
                } else if (player3Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : チョキ");
                    //プレイヤー3の手がパーだった時
                } else if (player3Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : パー");
                }
                //プレイヤー4の手がグーだった時
                if (player4Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player4Name + " : グー");
                    //プレイヤー4の手がチョキだった時
                } else if (player4Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player4Name + " : チョキ");
                    //プレイヤー4の手がパーだった時
                } else if (player4Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player4Name + " : パー");
                }
                //プレイヤー5の手がグーだった時
                if (player5Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player5Name + " : グー");
                    //プレイヤー5の手がチョキだった時
                } else if (player5Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player5Name + " : チョキ");
                    //プレイヤー5の手がパーだった時
                } else if (player5Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player5Name + " : パー");
                }
                //プレイヤー人数が4人の時
            } else if (howManyPlayer == 4) {
                //プレイヤー1の手がグーだった時
                if (player1Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : グー");
                    //プレイヤー1の手がチョキだった時
                } else if (player1Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : チョキ");
                    //プレイヤー1の手がチョキだった時
                } else if (player1Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : パー");
                }
                //プレイヤー2の手がグーだった時
                if (player2Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player2Name + " : グー");
                    //プレイヤー2の手がチョキだった時
                } else if (player2Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : チョキ");
                    //プレイヤー2の手がパーだった時
                } else if (player2Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player2Name + " : パー");
                }
                //プレイヤー3の手がグーだった時
                if (player3Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : グー");
                    //プレイヤー3の手がチョキだった時
                } else if (player3Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : チョキ");
                    //プレイヤー3の手がパーだった時
                } else if (player3Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : パー");
                }
                //プレイヤー4の手がグーだった時
                if (player4Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player4Name + " : グー");
                    //プレイヤー4の手がチョキだった時
                } else if (player4Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player4Name + " : チョキ");
                    //プレイヤー4の手がパーだった時
                } else if (player4Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player4Name + " : パー");
                }
                //プレイヤー人数3人の時
            } else if (howManyPlayer == 3) {
                //プレイヤー1の手がグーだった時
                if (player1Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : グー");
                    //プレイヤー1の手がチョキだった時
                } else if (player1Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : チョキ");
                    //プレイヤー1の手がチョキだった時
                } else if (player1Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : パー");
                }
                //プレイヤー2の手がグーだった時
                if (player2Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player2Name + " : グー");
                    //プレイヤー2の手がチョキだった時
                } else if (player2Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : チョキ");
                    //プレイヤー2の手がパーだった時
                } else if (player2Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player2Name + " : パー");
                }
                //プレイヤー3の手がグーだった時
                if (player3Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : グー");
                    //プレイヤー3の手がチョキだった時
                } else if (player3Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : チョキ");
                    //プレイヤー3の手がパーだった時
                } else if (player3Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player3Name + " : パー");
                }
                //プレイヤー人数が2人の時
            } else if (howManyPlayer == 2) {
                //プレイヤー1の手がグーだった時
                if (player1Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : グー");
                    //プレイヤー1の手がチョキだった時
                } else if (player1Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : チョキ");
                    //プレイヤー1の手がチョキだった時
                } else if (player1Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : パー");
                }
                //プレイヤー2の手がグーだった時
                if (player2Hand == STONE) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player2Name + " : グー");
                    //プレイヤー2の手がチョキだった時
                } else if (player2Hand == SCISSORS) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player1Name + " : チョキ");
                    //プレイヤー2の手がパーだった時
                } else if (player2Hand == PAPER) {
                    //プレイヤーの名前と出した手を表示
                    System.out.println(player2Name + " : パー");
                }
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
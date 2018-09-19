/*
  演習5-2 Tacticsインターフェースを実装して、以下に示す仕様を満たす戦略クラス「CyclicTactics」を作成し、ObjectJankenに組み込んで実行してください。
          [仕様]グー・チョキ・パーを順番に出すこと
  演習日  9月3日
  製作者  玉利仁美
 */

package work5_2;

//審判クラス
public class Judge {

    /**
     * ジャンケンを開始するときの審判の挙動
     * @author 玉利
     * @param player1 プレイヤークラスので作られたプレイヤー1の情報
     * @param player2 プレイヤークラスので作られたプレイヤー2の情報
     */
    //2人でジャンケンを行うときの審判が行う挙動
    public void startJanken(Player player1, Player player2) {
        //ジャンケンを開始するときに表示する文言
        System.out.println("【ジャンケン開始】\n");
        //ゲームを3回行うので、3回繰り返す
        for (int cnt = 0; cnt < 3; cnt++) {
            //何回目の試合なのかを表示する
            System.out.println("【" + (cnt + 1) + "回戦目】");
            //勝者はジャンケンが勝ったか負けたかを判定するメソッドから求める
            Player winner = judgeJanken(player1, player2);
            //winnerがNull以外つまり引き分け以外の時
            if (winner != null) {
                //どちらが勝ったかを表示する
                System.out.println("\n" + winner.getName() + "が勝ちました！\n");
                //=========③勝ったプレイヤーへ結果を伝える===================
                //勝者に勝ち数1を追加する
                winner.notifyResult(true);
                //=========③勝ったプレイヤーへ結果を伝える===================
                //勝者がいなければ
            } else {
                //引き分けと表示する
                System.out.println("\n引き分けです！\n");
            }
        }
        //ジャンケンが終了したことを表示する
        System.out.println("【ジャンケン終了】\n");

        //最終的な勝者が誰であるかを判定するメソッドで総合勝者を求める
        Player finalWinner = judgeFinalWinner(player1, player2);

        //プレイヤー1の勝ち数とプレイヤー2の勝ち数を表示
        System.out.print(player1.getWinCount() + "対" + player2.getWinCount() + "で");
        //総合勝者がいるとき
        if (finalWinner != null) {
            //総合勝者の名前と勝ちということを明示する
            System.out.println(finalWinner.getName() + "の勝ちです！\n ");
            //総合勝者がいないとき
        } else {
            //2人の勝ち数は同じで引き分けとなる
            System.out.println("引き分けです！\n");
        }
    }

    /**
     * ジャンケンの勝者を決めるメソッド
     * @author 玉利
     * @param player1 プレイヤー1の手などを持ったプレイヤークラス
     * @param player2 プレイヤー2の手などを持ったプレイヤークラス
     * @return 勝ったプレイヤーを返す
     */
    //プレイヤー同士の手から勝者を返すメソッド
    private Player judgeJanken(Player player1, Player player2) {
        //勝者がいなかった時のことを踏まえて引き分けのために初期値をnullにしておく
        Player winner = null;
        //=======①プレイヤー1の手を出す============================
        //プレイヤー1の手はプレイヤークラス内から取得してくる
        int player1hand = player1.showHand();
        //=======①プレイヤー1の手を出す============================

        //=======②プレイヤー2の手を出す============================
        //プレイヤー2の手はプレイヤークラス内から取得してくる
        int player2hand = player2.showHand();
        //=======②プレイヤー2の手を出す============================

        //プレイヤー1の手をグーチョキパーで表すメソッドを呼び出し表示する
        printHand(player1hand);
        //プレイヤー1の手とプレイヤー2の手を比べていることを表現する
        System.out.print(" Vs. ");
        //プレイヤー2の手をグーチョキパーで表すメソッドを呼び出し表示する
        printHand(player2hand);
        //改行を行う
        System.out.print("\n");

        //プレイヤー1の手が勝てる組み合わせの時
        if ((player1hand == Player.STONE && player2hand == Player.SCISSORS)
                || (player1hand == Player.SCISSORS && player2hand == Player.PAPER)
                || (player1hand == Player.PAPER && player2hand == Player.STONE)) {
            //勝者にプレイヤー1を代入する
            winner = player1;
            //プレイヤー2の手が勝てる組み合わせの時
        } else if ((player1hand == Player.STONE && player2hand == Player.PAPER)
                || (player1hand == Player.SCISSORS && player2hand == Player.STONE)
                || (player1hand == Player.PAPER && player2hand == Player.SCISSORS)) {
            //勝者にプレイヤー2を代入する
            winner = player2;
        }
        //勝者を返す
        return winner;
    }

    /**
     * 3回勝負の勝者を求めるメソッド
     * @author 玉利
     * @param player1 2人の内のプレイヤーの内の1人目
     * @param player2 2人の内のプレイヤーの内の2人目
     * @return 総合的に勝ったプレイヤーを返す
     */
    //3回戦勝負の最終的な勝者を求める
    private Player judgeFinalWinner(Player player1, Player player2) {
        //引き分けに備えて勝者の初期値はnullにしておく
        Player winner = null;
        //=========④Player1から勝ち数を聞く===========================
        //プレイヤー1の勝利数をプレイヤークラスから取得する
        int player1WinCount = player1.getWinCount();
        //=========④Player1から勝ち数を聞く===========================
        //=========⑤Player2から勝ち数を聞く===========================
        //プレイやー2の勝利数をプレイヤークラスから取得する
        int player2WinCount = player2.getWinCount();
        //=========⑤Player2から勝ち数を聞く===========================

        //プレイヤー1がプレイヤー2の勝利数より多いとき
        if (player1WinCount > player2WinCount) {
            //勝者はプレイヤー1となる
            winner = player1;
            //プレイヤー2がプレイヤー1の勝利数より多いとき
        } else if (player1WinCount < player2WinCount) {
            //勝者はプレイヤー2となる
            winner = player2;
        }
        //総合的な勝利のプレイヤーを返す
        return winner;
    }

    /**
     * 引数に受け取った数字を対応する手に修正するメソッド
     * @author 玉利
     * @param hand ジャンケンの手
     */
    //引数に受け取った数字を対応する手に修正する
    private void printHand(int hand) {
        //引数に受け取った数字によって表示する手を変える
        switch (hand) {
        //受け取った数字が0なら
        case Player.STONE:
            //グーを表示する
            System.out.print("グー");
            //スイッチ文を終了させる
            break;
        //受け取った数字が1なら
        case Player.SCISSORS:
            //チョキを表示させる
            System.out.print("チョキ");
            //スイッチ文を終了させる
            break;
        //受け取った数字が2なら
        case Player.PAPER:
            //パーを表示させる
            System.out.print("パー");
            //スイッチ文を終了させる
            break;
        //それ以外の数字が入ったら
        default:
            //スイッチ文を終了させる
            break;
        }
    }

}

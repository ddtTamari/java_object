/*
  演習5-2 Tacticsインターフェースを実装して、以下に示す仕様を満たす戦略クラス「CyclicTactics」を作成し、ObjectJankenに組み込んで実行してください。
          [仕様]グー・チョキ・パーを順番に出すこと
  演習日  9月3日
  製作者  玉利仁美
 */
package work5_2;

//戦略インターフェースを実装するクラス
public class CyclicTactics implements Tactics {

    //グーチョキパーが順番に来るように何回目なのかを格納する変数を準備する
    private int times = 0;

    /**
     * グーチョキパーが順番に返される戦略を実装するメソッド
     * @author 玉利
     * @return プレイヤーの出す手
     */
    //戦略インターフェースを実装するメソッド
    public int readTactics() {

        //返却する手を０で初期化しておく
        int hands = 0;

        //ゲーム回数が3回以上になってもグーチョキパーの順になるように回数を3で割る
        switch (times % 3) {
        //回数を3で割ったあまりが0なら
        case 0:
            //グーチョキパーの順になるようグーで代入する
            hands = Player.STONE;
            //回数をプラス一回する
            times++;
            //Case文を抜ける
            break;
        //回数を3で割ったあまりが1なら
        case 1:
            //グーチョキパーの順になるようチョキで代入する
            hands = Player.SCISSORS;
            //回数をプラス一回する
            times++;
            //Case文を抜ける
            break;
        //回数を3で割ったあまりが2なら
        case 2:
            //グーチョキパーの順になるようパーで代入する
            hands = Player.PAPER;
            //回数をプラス一回する
            times++;
            //Case文を抜ける
            break;
        //上記ケースの値に当てはまらないとき
        default:
            //Case文を抜ける
            break;
        }
        //ケースで分けられて代入された手を返す
        return hands;

    }

}

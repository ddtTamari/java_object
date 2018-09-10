/*
  演習5-2 Tacticsインターフェースを実装して、以下に示す仕様を満たす戦略クラス「CyclicTactics」を作成し、ObjectJankenに組み込んで実行してください。
          [仕様]グー・チョキ・パーを順番に出すこと
  演習日  9月3日
  製作者  玉利仁美
 */

package work5_2;

//ジャンケンを行うクラス
public class ObjectJanken {
    /**メインメソッド
     * @author 玉利
     * @param args コマンドライン
     */
    //メインメソッド
    public static void main(String[] args) {

        //ゲームを進行させる審判クラスの斎藤さんを準備する
        Judge saito = new Judge();

        //リスト4-2の内容=====================================================
        //Murataクラスの村田さんを作成する
        Player murata = new Murata("村田さん");
        Tactics murataTactics = new CyclicTactics();
        murata.setTactics(murataTactics);

        //Yamadaクラスの山田さんを作成する
        Player yamada = new Yamada("山田さん");

        //startJankenで村田さんと山田さんの勝負の結果を求める
        saito.startJanken(murata, yamada);

        //=====================================================================

    }

}

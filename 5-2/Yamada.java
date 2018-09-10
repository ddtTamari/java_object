/*
  演習5-2 Tacticsインターフェースを実装して、以下に示す仕様を満たす戦略クラス「CyclicTactics」を作成し、ObjectJankenに組み込んで実行してください。
          [仕様]グー・チョキ・パーを順番に出すこと
  演習日  9月3日
  製作者  玉利仁美
 */
package work5_2;

//Playerクラスを継承した山田クラス
public class Yamada extends Player {
    //名前をきめるコンストラクタ
    public Yamada(String name) {
        //親クラスのコンストラクタを利用する
        super(name);
    }

    /**
     * プレイヤーが出す手を決めるメソッド
     * @author 玉利
     */
    //親クラスのメソッドを上書きする
    @Override
    //プレイヤーが出す手を決めるメソッド
    public int showHand() {
        //出す手は必ずグーにする
        return STONE;
    }
}

/*
  演習5-2 Tacticsインターフェースを実装して、以下に示す仕様を満たす戦略クラス「CyclicTactics」を作成し、ObjectJankenに組み込んで実行してください。
          [仕様]グー・チョキ・パーを順番に出すこと
  演習日  9月3日
  製作者  玉利仁美
 */
package work5_2;

//戦略に必要な条件を定義する
public interface Tactics {
    /**
     *戦略を読み込むためのメソッド
     */
    //戦略を読み込むためのメソッド
    public int readTactics();
}

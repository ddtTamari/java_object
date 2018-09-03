/*
  演習5-1 Playerクラス(リストA-2)を修正し、Tacticsインターフェースを使用してジャンケンの手を決めるよう、変更してください。
  演習日  8月29日
  製作者  玉利仁美
 */
package work5_1;

//戦略に必要な条件を定義する
public interface Tactics {
    /*
     *戦略を読み込むためのメソッド
     */
    //戦略を読み込むためのメソッド
    public int readTactics();
}

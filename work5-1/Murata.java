/*
  演習5-1 Playerクラス(リストA-2)を修正し、Tacticsインターフェースを使用してジャンケンの手を決めるよう、変更してください。
  演習日  8月29日
  製作者  玉利仁美
 */
package work5_1;

//Playerクラスを継承した村田クラス
public class Murata extends Player {

    //名前をきめるコンストラクタ
    public Murata(String name) {
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
        //出す手は必ずパーにする
        return PAPER;
    }
}

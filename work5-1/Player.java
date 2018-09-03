/*
  演習5-1 Playerクラス(リストA-2)を修正し、Tacticsインターフェースを使用してジャンケンの手を決めるよう、変更してください。
  演習日  8月29日
  製作者  玉利仁美
 */
package work5_1;

//プレイヤークラス
public class Player {

    //ジャンケンで出す手を定数で宣言する
    public static final int STONE = 0;
    //ジャンケンで出す手を定数で宣言する
    public static final int SCISSORS = 1;
    //ジャンケンで出す手を定数で宣言する
    public static final int PAPER = 2;

    //プレイヤーの名前を定義する
    private String name_;

    //戦略を入れるための変数を用意する
    private Tactics tactics_;

    //プレイヤーの勝った数を保持するための変数
    private int winCont_ = 0;

    //名前を取得するコンストラクタ
    public Player(String name) {
        //フィールドに名前を挿入する
        name_ = name;
    }

    /**
     * プレイヤーの手を決めるメソッド
     * @author 玉利
     * @return プレイヤーの手
     */
    //プレイヤーの手を決め返すメソッド
    public int showHand() {
        int playerHand = tactics_.readTactics();

        //ランダムに出た手を返す
        return playerHand;
    }

    /**
     * プレイヤーの勝利数を保持するためのメソッド
     * @author 玉利
     * @param result true:勝ち,false:負け
     */
    //審判からもらった勝利判定をもとに勝利数を計算するメソッド
    public void notifyResult(boolean result) {
        //審判からの勝敗が勝ちならば
        if (result == true) {
            //勝利数に1を追加する
            winCont_ = winCont_ + 1;
        }
    }

    /**
     * 戦略を設定するためのメソッド
     * @author 玉利
     */
    //戦略を設定するためのメソッド
    public void setTactics(Tactics tactics) {
        //戦略を引数の戦略インターフェースからセットする
        tactics_ = tactics;
    }

    /**
     * 審判が勝利数を取得できるようにするメソッド
     * @author 玉利
     * @return プレイヤーの勝利数
     */
    //審判が最終判定に使う結果を出すための値を返す
    public int getWinCount() {
        //カウントされた勝利数を返す
        return winCont_;
    }

    /**
     * プレイヤーの名前を返すメソッド
     * @author小森裕介
     * @return
     */
    //プレイヤーの名前を返すメソッド
    public String getName() {
        //名前を返す
        return name_;
    }

}



package work4_1;

public class Murata {

    //ジャンケンで出す手を定数で宣言する
    public static final int STONE = 0;
    //ジャンケンで出す手を定数で宣言する
    public static final int SCISSORS = 1;
    //ジャンケンで出す手を定数で宣言する
    public static final int PAPER = 2;

    //プレイヤーの名前を定義する
    private String name_;

    //プレイヤーの勝った数を保持するための変数
    private int winCont_ = 0;

    /**
     * プレイヤーの手を決めるメソッド
     * @author 玉利
     * @return プレイヤーの手
     */
    //プレイヤーの手を決め返すメソッド
    public int showHand() {
        //プレイヤーの手を保持するための変数
        int playerHand = 0;
        //0~3までの数字を出すための変数
        int adjustRandomNum = 3;
        //1未満の時はグーと判断する変数
        int judgePlayerHandStone = 1;
        //2未満の時はチョキと判断する変数
        int judgePlayerHandScissors = 2;
        //3未満の時はグーと判断する変数
        int judgePlayerHandPaper = 3;

        //0から3までのランダムな変数を出すための変数
        double randomNum = Math.random() * adjustRandomNum;
        //ランダムな手の値が1未満ならPlayer1の出す手はグーにする
        if (randomNum < judgePlayerHandStone) {
            //プレイヤー1の手はグー
            playerHand = STONE;
            //プレイヤー1がグーだったことを明示する
            System.out.print("グー");
            //ランダムで出た値が1以上2未満なら出す手はチョキになる
        } else if (randomNum < judgePlayerHandScissors) {
            //プレイヤー1の手はチョキ
            playerHand = SCISSORS;
            //プレイヤー1がチョキだったことを明示する
            System.out.print("チョキ");
            //ランダムで出た値が2以上3未満なら出す手はパーになる
        } else if (randomNum < judgePlayerHandPaper) {
            //プレイヤー1の手はチョキ
            playerHand = PAPER;
            //プレイヤー1がパーだったことを明示する
            System.out.print("パー");
        }
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

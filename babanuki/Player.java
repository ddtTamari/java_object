package babanuki;

import java.util.List;
import java.util.Scanner;

public class Player {
    private String mUserName;//プレイヤーの名前
    private BabanukiManage manageBabaGame = new BabanukiManage();//ババ抜きのマネージャー
    private ConvertTrumpCard convertTrump = new ConvertTrumpCard();//トランプ変換クラス
    private List<Integer> playersHands = manageBabaGame.getPlayerHand();//プレイヤーの手札
    Scanner userImput = new Scanner(System.in);//引くカードの位置を取得

    //コンストラクタ群

    public Player() {
    }

    //プレイヤーの名前をセットする
    public Player(String userName) {
        //プレイヤーの名前をセットする
        this.mUserName = userName;
    }

    /**
     * メソッド名：getPlayerName
     * @author Tamari
     * @param
     * @return mUserName：プレイヤーの名前
     * 処理内容：プレイヤーの名前を返す
     */
    //プレイヤーの名前を返却
    public String getPlayerName() {
        //プレイヤーの名前を返す
        return mUserName;
    }

    /**
     * メソッド名：setPlayerHand
     * @author Tamari
     * @param  card：カードの値
     * @return
     * 処理内容：プレイヤーの手札に登録する
     */
    //引数に渡されたカードを手札に登録
    public void setPlayerHand(int card) {
        //手札に登録する
        manageBabaGame.setPlayerHand(card);
    }

    /**
     * メソッド名：removePlayerHand
     * @author Tamari
     * @param  card：カードの要素番号
     * @return
     * 処理内容：引かれたカードを捨てる
     */
    //引かれた手札を捨てる
    public void removePlayerHand(int cardId) {
        //プレイヤーの手札を捨てる
        manageBabaGame.throwCard(cardId);
    }

    /**
     * メソッド名：checkSameNumHand
     * @author Tamari
     * @param
     * @return
     * 処理内容：同じ数字があるかどうか確認する
     */
    //同じ数字があるかどうか確認
    public void checkSameNumHand() {
        //同じ数字があるかどうかを確認
        manageBabaGame.checkSameNum();
    }

    /**
     * メソッド名：isFinish
     * @author Tamari
     * @param
     * @return finish：プレイヤーが上がっているかどうか(True:上がった/False:上がっていない)
     * 処理内容：プレイヤーの手札が0枚か判定する
     */
    //手札がなくなったプレイヤーじゃないか確認
    public boolean isFinish() {
        //手札0かどうかの判定をする変数
        boolean finish = false;
        //プレイヤーの手札のサイズが0の時
        if (playersHands.size() == Constant.INITIAL_NUM) {
            //終わったか判定する
            finish = true;
        }
        //手札0かどうかを返す
        return finish;
    }

    /**
     * メソッド名：isFinish
     * @author Tamari
     * @param
     * @return playersHands.size()：プレイヤーの手札の長さ
     * 処理内容：プレイヤーの手札を返す
     */
    //手札のサイズを返却するメソッド
    public int handsSize() {
        //手札の枚数を返す
        return playersHands.size();
    }

    /**
     * メソッド名：retHands
     * @author Tamari
     * @param
     * @return manageBabaGame.retCard(getCardId)：指定された位置のカードの値を返す
     * 処理内容：プレイヤーの手札を返す
     */
    //指定するインデックスのカードを返す
    public int retHands(int getCardId) {
        //指定されたインデックスのカードを返却する
        return manageBabaGame.retCard(getCardId);
    }


    /**
     * メソッド名：retHands
     * @author Tamari
     * @param opponent:カードを引くプレイヤークラス
     * @return
     * 処理内容：プレイヤーからカードを引く
     */
    //カードを引く動作を行う
    public void drawPlayersHand(Player opponent) {
        //カードが引かれる手札の位置
        int drawPosition = Constant.INITIAL_NUM;
        //手札の枚数の範囲で指定するまで繰り返す
        while (Constant.INITIAL_NUM >= drawPosition || drawPosition > opponent.handsSize()) {
            //どのポジションを引くか聞く
            System.out.println(mUserName + Constant.ASK_DRAW_POSITION);
            //キーボードから値を取得する
            drawPosition = userImput.nextInt();
        }
        //カードの引かれる位置を要素数になるよう合わせる
        drawPosition = drawPosition - Constant.ADJUST_ELEMENT_NUM;

        //引いたプレイヤーの手札に新たに引いたカードを追加する
        setPlayerHand(opponent.retHands(drawPosition));
        //引かれたプレイヤーのカードを削除する
        opponent.removePlayerHand(drawPosition);
    }

    /**
     * メソッド名：showHands
     * @author Tamari
     * @param id:手札の要素番号
     * @return
     * 処理内容：手札を表示する
     */
    //手札表示用(デバッグ用)
    public void showHands(String id) {
        //プレイヤーの手札枚数の表示
        System.out.println(id + Constant.USER_HAS + handsSize() + Constant.NUM_OF_USER_HANDS);
        //手札をプレイヤーにわかるように変換する
        convertTrump();
        //改行する
        System.out.println();
    }

    /**
     * メソッド名：convertTrump
     * @author Tamari
     * @param
     * @return
     * 処理内容：手札を変換させる
     */
    //スート数字変換
    public void convertTrump() {
        //全ての手札を表示
        for (int elements : playersHands) {
            //スート変換
            String suit = convertTrump.convertTrumpSuit(elements);
            //数字変換
            int num = convertTrump.convertTrumpNum(elements);
            //カード名を表示
            System.out.print(suit + num);
            //仕切りを表示
            System.out.print("|");
        }
    }
}

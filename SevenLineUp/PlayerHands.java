package shichinarabe;

import java.util.ArrayList;
import java.util.List;

public class PlayerHands {
    //プレイヤーの手札のリスト
    private List<Integer> mPlayerHandsList = new ArrayList<>();
    private ConvertTrumpCard mConverter = new ConvertTrumpCard();

    //コンストラクタ
    public void playersHands() {
    }

    /**
     * メソッド名：addPlayerHand
     * @author Tamari
     * @param inputCards：登録するカードの値
     * @return
     * 処理内容：手札リストに登録する
     */
    //手札リストに登録
    public void addPlayerHand(int inputCards) {
        //手札に加える
        mPlayerHandsList.add(inputCards);
    }

    /**
     * メソッド名：disCardHand
     * @author Tamari
     * @param  drpCardId：除外するカードの要素番号
     * @return
     * 処理内容：手札リストから除外する
     */
    //カードが引かれる処理
    public void dropCard(int drpCardId) {
        System.out.println(mConverter.convertTrumpCard(mPlayerHandsList.get(drpCardId)) + "はテーブルに出されました。");
        //手札から引かれたカードを消す
        mPlayerHandsList.remove(drpCardId);
    }

    /**
     * メソッド名：getPlayerHand
     * @author Tamari
     * @param
     * @return playerHandsList：プレイヤーの手札を返す
     * 処理内容：プレイヤーの手札を返す
     */
    //プレイヤーの手札のリストを返す
    public List<Integer> getPlayerHand() {
        //プレイヤーの手札を返す
        return mPlayerHandsList;
    }

    /**
     * メソッド名：hasTheNum
     * @author Tamari
     * @param trumpId:手札の要素番号
     *         targetNum:確認対象のトランプの数字
     * @return hasNum:ターゲットの数字を持っているかどうか
     * 処理内容：ture；ターゲットの数字のカードである/False:ターゲットの数字のカードではない
     */
    public boolean hasTheNum(int trumpId, int targetNum) {
        boolean hasNum = false;

        if (mPlayerHandsList.get(trumpId) == targetNum) {
            hasNum = true;
        }

        return hasNum;
    }

    /**
     * メソッド名：hasTheTrump
     * @author Tamari
     * @param trumpId:手札の要素番号
     *         targetNum:確認対象のトランプの数字
     *         targetSuit:確認対象のトランプのスート
     * @return hasNum:ターゲットの数字を持っているかどうか
     * 処理内容：ture；ターゲットのトランプである/False:ターゲットのトランプではない
     */
    public boolean hasTheTrump(int trumpId, int targetNum, int targetSuit) {
        boolean hasTrump = false;

        if ((targetNum | targetSuit) == mPlayerHandsList.get(trumpId)) {
            hasTrump = true;
        }
        return hasTrump;
    }

    public int getTrumpNum(int targetElement) {
        return mPlayerHandsList.get(targetElement);
    }

}

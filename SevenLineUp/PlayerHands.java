package shichinarabe;

import java.util.ArrayList;
import java.util.List;

public class PlayerHands {
    //プレイヤーの手札のリスト
    private List<Integer> mPlayerHandsList = new ArrayList<>();

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

    public boolean hasTheNum(int trumpId, int targetNum) {
        boolean hasNum = false;

        if ((mPlayerHandsList.get(trumpId) & Constant.TRUMP_SUIT_HEART_ELEMENT) == targetNum) {
            hasNum = true;
        } else if ((mPlayerHandsList.get(trumpId)
                & Constant.TRUMP_SUIT_DIAMOND_ELEMENT) == targetNum) {
            hasNum = true;
        } else if ((mPlayerHandsList.get(trumpId)
                & Constant.TRUMP_SUIT_SPADE_ELEMENT) == targetNum) {
            hasNum = true;
        } else if ((mPlayerHandsList.get(trumpId)
                & Constant.TRUMP_SUIT_CLUB_ELEMENT) == targetNum) {
            hasNum = true;
        }

        return hasNum;
    }

    public int getTrumpNum(int targetElement) {
        return mPlayerHandsList.get(targetElement);
    }

}

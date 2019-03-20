package babanuki;

import java.util.ArrayList;
import java.util.List;

//念のための捨てカードリスト
public class DiscardTable {
    //捨てカード一覧
    List<Integer> discardList = new ArrayList<>();
    //変換用クラス
    private ConvertTrumpCard convertTrump = new ConvertTrumpCard();

    /**
     * メソッド名：DiscardTable
     * @author Tamari
     * @param  discardCard : カードの値
     *          discardCardTwo：カードの値2
     * @return
     * 処理内容：捨てられたカードリストに登録する
     */
    //そろって捨てられたカードを登録する
    public void setDiscardList(int discardCard, int discardCardTwo) {
        //捨てられたカードリストに追加
        discardList.add(discardCard);
        //捨てられたカードリストに追加
        discardList.add(discardCardTwo);
        //捨てられたカードを表示する
        showList(discardCard, discardCardTwo);
    }

    /**
     * メソッド名：showList
     * @author Tamari
     * @param  discardCard : カードの値
     *          discardCardTwo：カードの値2
     * @return
     * 処理内容：捨てられたカードを表示する
     */
    //捨てられたカードがそろったカードか確認するためのメソッド
    public void showList(int discardCard, int discardCardTwo) {
        //捨てられたカードを表示する
        System.out.println(
                convertTrump.convertTrumpSuit(discardCard) + convertTrump.convertTrumpNum(discardCard) + Constant.DROP_CARD_MASSAGE);
        //捨てられたカードを表示する
        System.out.println(
                convertTrump.convertTrumpSuit(discardCardTwo) + convertTrump.convertTrumpNum(discardCardTwo)
                        + Constant.DROP_CARD_MASSAGE);
    }
}

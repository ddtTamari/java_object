package shichinarabe;

import java.util.ArrayList;
import java.util.List;

public class DiscardTable {
    //捨てカード一覧
    List<Integer> mDiscardList = new ArrayList<>();
    //変換用クラス
    private ConvertTrumpCard mConvertTrump = new ConvertTrumpCard();

    /**
     * メソッド名：DiscardTable
     * @author Tamari
     * @param  discardCard : カードの値
     *          discardCardTwo：カードの値2
     * @return
     * 処理内容：捨てられたカードリストに登録する
     */
    //そろって捨てられたカードを登録する
    public void setDiscardList(int discardCard) {
        //捨てられたカードリストに追加
        mDiscardList.add(discardCard);
        //捨てられたカードを表示する
        showList(discardCard);
    }

    /**
     * メソッド名：showDropCard
     * @author Tamari
     * @param  discardCard : カードの値
     * @return
     * 処理内容：捨てられたカードを表示する
     */
    //捨てられたカードがそろったカードか確認するためのメソッド
    public void showList(int discardCard) {
        //捨てられたカードを表示する
        System.out.println(
                mConvertTrump.convertTrumpSuit(discardCard) + mConvertTrump.convertTrumpNum(discardCard)
        /*+ MessageConstant.DROP_CARD_MESSAGE*/);
    }
}

package babanuki;

import java.util.ArrayList;
import java.util.List;

//念のための捨てカードリスト
public class DiscardTable {
    //捨てカード一覧
    List<Integer> discardList = new ArrayList<>();
    //
    private ConvertTrumpCard convertTrump = new ConvertTrumpCard();

    //
    public void setDiscardList(int discardCard) {
        //捨てられたカードリストに追加
        discardList.add(discardCard);
        //捨てられたカードを表示する
        showList(discardCard);
    }

    //捨てられたカードがそろったカードか確認するためのメソッド
    public void showList(int discardCard) {
        //捨てられたカードを表示する
        System.out.println(
                convertTrump.convertTrumpSuit(discardCard) + convertTrump.convertTrumpNum(discardCard) + "は捨てられた…");
    }
}

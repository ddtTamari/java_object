
package babanuki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

    /*
     ハート：000000
     ダイア：010000
     スペード：100000
     クラブ：110000
     ジョーカー：111111
     */

    private List<Integer> trumpCardList = new ArrayList<>();
    private int[] usedCard = new int[Constant.MAX_TRUMP_NUM];

    //カード配布のメソッド
    public void distributionCards(int playerNum) {
        //トランプリストを作成
        setTrumpList();
        //トランプをシャッフル
        shuffleTrumpList();
    }

    //ArrayListにトランプ53枚用意する
    public void setTrumpList() {
        //スートの数だけ1~13の数字を生成するのを繰り返す
        for (int suitNum = Constant.INITIAL_NUM; suitNum < Constant.TRUMP_SUIT_NUM; suitNum++) {
            //スートに対して1~13までの数字を当てはめてく
            for (int trumpNum = Constant.INITIAL_NUM; trumpNum < Constant.MAX_NUMBER_OF_TRUMP; ++trumpNum) {
                //スートによって数字を決める
                setTrumpCard(suitNum, trumpNum + Constant.ADJUST_ELEMENT_NUM);
            }
        }
        trumpCardList.add(Constant.TRUMP_SUIT_JOKER);
    }

    //スートと数字を組み合わせる
    public void setTrumpCard(int suitNum, int cardNum) {
        switch (suitNum) {
        case Constant.TRUMP_SUIT_HEART_ELEMENT:
            trumpCardList.add(Constant.TRUMP_SUIT_HEART | cardNum);
            break;
        case Constant.TRUMP_SUIT_DIAMOND_ELEMENT:
            trumpCardList.add(Constant.TRUMP_SUIT_DIAMOND | cardNum);
            break;
        case Constant.TRUMP_SUIT_SPADE_ELEMENT:
            trumpCardList.add(Constant.TRUMP_SUIT_SPADE | cardNum);
            break;
        case Constant.TRUMP_SUIT_CLUB_ELEMENT:
            trumpCardList.add(Constant.TRUMP_SUIT_CLUB | cardNum);
            break;
        default:
            break;
        }
    }

    //トランプリストをシャッフル
    public void shuffleTrumpList() {
        Collections.shuffle(trumpCardList);
    }

    //使用済みカードの登録
    public void imputUsedCardList(int imputCardNum, int elementNum) {
        usedCard[elementNum] = imputCardNum;
    }

    //
    public void registPlayerHand(int card) {

    }

}

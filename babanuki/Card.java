
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

    //全トランプのカードを格納するためのリスト
    private List<Integer> mTrumpCardList = new ArrayList<>();

    //カード作成とシャッフル処理のメソッド
    public void shuffleCards() {
        //トランプリストを作成
        setTrumpList();
        //トランプをシャッフル
        shuffleTrumpList();
    }

    //ArrayListにトランプ53枚用意する
    private void setTrumpList() {
        //スートの数だけ1~13の数字を生成するのを繰り返す
        for (int suitNum = Constant.INITIAL_NUM; suitNum < Constant.TRUMP_SUIT_NUM; suitNum++) {
            //スートに対して1~13までの数字を当てはめてく
            for (int trumpNum = Constant.INITIAL_NUM; trumpNum < Constant.MAX_NUMBER_OF_TRUMP; ++trumpNum) {
                //スートによって数字を決める
                setTrumpCard(suitNum, trumpNum + Constant.ADJUST_ELEMENT_NUM);
            }
        }
        //トランプリストにカードを登録する
        mTrumpCardList.add(Constant.TRUMP_SUIT_JOKER);
    }

    //スートと数字を組み合わせ処理
    private void setTrumpCard(int suitNum, int cardNum) {
        //スートごとに1~13までの数字を入れていく
        switch (suitNum) {
        //ハートの要素の時
        case Constant.TRUMP_SUIT_HEART_ELEMENT:
            //カードの数字とスートの数字を合わせトランプリストに格納する
            mTrumpCardList.add(Constant.TRUMP_SUIT_HEART | cardNum);
            //Switch文を抜ける
            break;
        //ダイアの要素の時
        case Constant.TRUMP_SUIT_DIAMOND_ELEMENT:
            //カードの数字とスートの数字を合わせトランプリストに格納する
            mTrumpCardList.add(Constant.TRUMP_SUIT_DIAMOND | cardNum);
            //Switch文を抜ける
            break;
        //スペードの要素の時
        case Constant.TRUMP_SUIT_SPADE_ELEMENT:
            //カードの数字とスートの数字を合わせトランプリストに格納する
            mTrumpCardList.add(Constant.TRUMP_SUIT_SPADE | cardNum);
            //Switch文を抜ける
            break;
        //クラブの要素の時
        case Constant.TRUMP_SUIT_CLUB_ELEMENT:
            //カードの数字とスートの数字を合わせトランプリストに格納する
            mTrumpCardList.add(Constant.TRUMP_SUIT_CLUB | cardNum);
            //Switch文を抜ける
            break;
        //上記のケース以外の時
        default:
            //Switch文を抜ける
            break;
        }
    }

    //トランプリストをシャッフル
    private void shuffleTrumpList() {
        //カードをシャッフルする
        Collections.shuffle(mTrumpCardList);
    }

    //カードを呼び出し元に渡す
    public int returnCard(int element) {
        //カードを返す
        return mTrumpCardList.get(element).intValue();
    }

}

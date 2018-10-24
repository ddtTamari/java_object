
package babanuki;

import java.util.ArrayList;
import java.util.Arrays;
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

    private boolean mIsUsed = true;
    //private int usedCard[] = new int[Constant.MAX_TRUMP_NUM];
    //        private int[] missingCardList = { Constant.MISSING_NUM_001110, Constant.MISSING_NUM_001111,
    //                Constant.MISSING_NUM_011110, Constant.MISSING_NUM_011111, Constant.MISSING_NUM_101110,
    //                Constant.MISSING_NUM_101111, Constant.MISSING_NUM_111110 };
    private List<Integer> mTrumpCardList = new ArrayList<>();

    //カード配布のメソッド
    public void distributionCards(int playerNum) {
        //トランプリストを作成
        setTrumpList();
        //トランプをシャッフル
        shuffleTrumpList();

        //53枚使いきるまで繰り返す
        for (int cardElements = Constant.INITIAL_NUM; cardElements < Constant.MAX_TRUMP_NUM; cardElements++) {

        }
    }

    //ArrayListにトランプ53枚用意しておく
    public void setTrumpList() {
        for (int i = Constant.INITIAL_NUM; i < Constant.MAX_TRUMP_NUM; i++) {
            mTrumpCardList.add(i);
        }
    }

    //トランプリストをシャッフル
    public void shuffleTrumpList() {
        Collections.shuffle(mTrumpCardList);
    }

    //ありえない数字の判定
    public boolean isMissingCard(int trampCard) {
        boolean missingCard = false;
        if (Arrays.asList(missingCard).contains(trampCard)) {
            missingCard = true;
        }
        return missingCard;
    }

    //使用済みカードの判定
    public boolean isUsedCard(int card) {
        boolean usedCard = false;
        if (Arrays.asList(usedCard).contains(card)) {
            usedCard = true;
        }
        return usedCard;
    }

    //無効番号の判定
    //    public boolean isImpossibleUseCard(int usedCardElements) {
    //        boolean impossibleCard = false;
    //        Random rand = new Random();
    //        while (mIsUsed = true) {
    //            mTrampCard = rand.nextInt(63) + 1;
    //            if (!isMissingCard(mTrampCard)) {
    //                if (!isUsedCard(mTrampCard)) {
    //                    imputUsedCardList(mTrampCard, usedCardElements);
    //                    impossibleCard = true;
    //                }
    //            }
    //        }
    //        return impossibleCard;
    //    }

    //使用済みカードの登録
    public void imputUsedCardList(int imputCardNum, int elementNum) {
        // usedCard[elementNum] = imputCardNum;
    }

    //
    public void registPlayerHand(int card) {

    }

}

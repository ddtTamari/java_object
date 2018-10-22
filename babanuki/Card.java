
package babanuki;

import java.util.Arrays;
import java.util.Random;

public class Card {

    /*
     ハート：000000
     ダイア：010000
     スペード：100000
     クラブ：110000
     ジョーカー：111111
     */

    private byte mHeartSuit = 0x00; //ハート
    private byte mDiamondSuit = 0x16; // ダイア
    private byte mSpadeSuit = 0x32; //スペード
    private byte mCrabeSuit = 0x48; // クラブ
    private boolean mIsUsed = true;
    private int usedCard[] = new int[Constant.TOTAL_TRUMP_NUM];
    private int[] missingCardList = { Constant.MISSING_NUM_001110, Constant.MISSING_NUM_001111,
            Constant.MISSING_NUM_011110, Constant.MISSING_NUM_011111, Constant.MISSING_NUM_101110,
            Constant.MISSING_NUM_101111, Constant.MISSING_NUM_111110 };

    public void distributionCards() {

        Random rand = new Random();
        int trampCard = Constant.INITIAL_NUM;

        for (int usedCardElements = 0; usedCardElements < usedCard.length; usedCardElements++) {
            while (mIsUsed = true) {
                trampCard = rand.nextInt(63) + 1;
                if (!isMissingCard(trampCard)) {
                   if(!isUsedCard(trampCard)) {
                       imputUsedCardList(trampCard, usedCardElements);
                   }
                }
            }
        }
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

    //
    public void imputUsedCardList(int imputCardNum, int elementNum) {
        usedCard[elementNum] = imputCardNum;
    }

}

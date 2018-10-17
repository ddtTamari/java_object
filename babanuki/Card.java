
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

    private byte heartSuit = 0x00; //ハート
    private byte diamondSuit = 0x16; // ダイア
    private byte spadeSuit = 0x32; //スペード
    private byte crabeSuit = 0x48; // クラブ
    private boolean usedOrNot = true;
    private int usedCard[] = new int[Constract.TOTAL_TRUMP_NUM];
    private int[] missingCardList = { Constract.MISSING_NUM_001110, Constract.MISSING_NUM_001111,
            Constract.MISSING_NUM_011110, Constract.MISSING_NUM_011111, Constract.MISSING_NUM_101110,
            Constract.MISSING_NUM_101111, Constract.MISSING_NUM_111110 };

    public void distributionCards() {

        Random rnd = new Random();
        int trampCard = 0;

        for (int i = 0; i < usedCard.length; i++) {
            while (usedOrNot = true) {
                trampCard = rnd.nextInt(63) + 1;
                if (!checkMissingNum(trampCard)) {
                    checkUsedOrNot(trampCard);
                }
            }
            if (usedOrNot = false) {
                imputUsedCardList(trampCard, i);
            }

        }
    }

    public boolean checkMissingNum(int trampCard) {
        boolean missingOrNot = false;
        if (Arrays.asList(missingOrNot).contains(trampCard)) {
            missingOrNot = true;
        }
        return missingOrNot;
    }

    public boolean checkUsedOrNot(int card) {
        if (Arrays.asList(usedCard).contains(card)) {
            usedOrNot = true;
        } else {
            usedOrNot = false;
        }
        return usedOrNot;
    }

    public void imputUsedCardList(int imputCardNum, int elementNum) {
        usedCard[elementNum] = imputCardNum;
    }

}

package shichinarabe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscardTable {
    //捨てカード一覧
    List<Integer> mDiscardList = new ArrayList<>();
    //変換用クラス
    private ConvertTrumpCard mConvertTrump = new ConvertTrumpCard();
    private List<Integer> mHeartTrump = new ArrayList<>();
    private List<Integer> mDiaTrump = new ArrayList<>();
    private List<Integer> mSpadeTrump = new ArrayList<>();
    private List<Integer> mClubTrump = new ArrayList<>();

    public void registTable(int card) {
        int suit = mConvertTrump.convertTrumpSuitNum(card);

        switch (suit) {
        case Constant.TRUMP_SUIT_HEART:
            mHeartTrump.add(card);
            break;
        case Constant.TRUMP_SUIT_DIAMOND:
            mDiaTrump.add(card);
            break;
        case Constant.TRUMP_SUIT_SPADE:
            mSpadeTrump.add(card);
            break;
        case Constant.TRUMP_SUIT_CLUB:
            mClubTrump.add(card);
            break;
        default:
            break;
        }

    }

    public void showTable() {
        System.out.println("=================Table================");
        setTblCard(mHeartTrump);
        setTblCard(mDiaTrump);
        setTblCard(mSpadeTrump);
        setTblCard(mClubTrump);
        System.out.println("======================================");
    }

    public int[] setCanPlayCard() {
        int[] minMaxArray = new int[8];
        minMaxArray[0] = getMinNumber(mHeartTrump);
        minMaxArray[1] = getMaxNumber(mHeartTrump);
        minMaxArray[2] = getMinNumber(mDiaTrump);
        minMaxArray[3] = getMaxNumber(mDiaTrump);
        minMaxArray[4] = getMinNumber(mSpadeTrump);
        minMaxArray[5] = getMaxNumber(mSpadeTrump);
        minMaxArray[6] = getMinNumber(mClubTrump);
        minMaxArray[7] = getMaxNumber(mClubTrump);
        return minMaxArray;
    }

    //
    private void setTblCard(List<Integer> targetList) {
        String tableCard = "";
        String trump = "";
        Collections.sort(targetList);
        tableCard = createSpace(targetList, Constant.SPACE_BEFORE);
        for (int handsCard : targetList) {
            trump = mConvertTrump.convertTrumpCard(handsCard);
            tableCard = tableCard + "|" + trump + "|";
        }
        tableCard = tableCard + createSpace(targetList, Constant.SPACE_AFTER);
        System.out.println(tableCard);
    }

    //埋まっていないカードのところに空白をいれるそり
    private String createSpace(List<Integer> targetList, int targetPlace) {
        int minSuitNumber = getMinNumber(targetList);
        int maxSuitNumber = getMaxNumber(targetList);

        String cardSpace = "";

        //最大値最小値が同じの時6つのスペースを作る
        if (minSuitNumber == maxSuitNumber) {
            cardSpace = Constant.SAME_MIN_MAX_SPACE;
        } else if (targetPlace == Constant.SPACE_BEFORE) {
            for (int spaceLoop = 0; spaceLoop < minSuitNumber - Constant.ADJUST_BEFORE_NUM; spaceLoop++) {
                cardSpace = cardSpace + Constant.CARD_SPACE;
            }
        } else if (targetPlace == Constant.SPACE_AFTER) {
            for (int spaceLoop = 0; spaceLoop < Constant.MAX_NUMBER_OF_TRUMP - maxSuitNumber; spaceLoop++) {
                cardSpace = cardSpace + Constant.CARD_SPACE;
            }
        }
        return cardSpace;
    }

    private int getMaxNumber(List<Integer> targetSuitList) {
        return Collections.max(targetSuitList);
    }

    private int getMinNumber(List<Integer> targetSuitList) {
        return Collections.min(targetSuitList);
    }

}

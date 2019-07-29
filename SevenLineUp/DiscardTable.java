package shichinarabe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscardTable {

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
            mHeartTrump.add(mConvertTrump.convertTrumpNum(card));
            break;
        case Constant.TRUMP_SUIT_DIAMOND:
            mDiaTrump.add(mConvertTrump.convertTrumpNum(card));
            break;
        case Constant.TRUMP_SUIT_SPADE:
            mSpadeTrump.add(mConvertTrump.convertTrumpNum(card));
            break;
        case Constant.TRUMP_SUIT_CLUB:
            mClubTrump.add(mConvertTrump.convertTrumpNum(card));
            break;
        default:
            break;
        }

    }

    public void showTable() {
        System.out.println("============Table===========");
        setTblCard(mHeartTrump, Constant.TRUMP_SUIT_HEART);
        setTblCard(mDiaTrump, Constant.TRUMP_SUIT_DIAMOND);
        setTblCard(mSpadeTrump, Constant.TRUMP_SUIT_SPADE);
        setTblCard(mClubTrump, Constant.TRUMP_SUIT_CLUB);
        System.out.println("============================");
    }

    public int[] setCanPlayCard() {
        int[] minMaxArray = new int[8];
        minMaxArray[0] = getMinNumber(mHeartTrump) + Constant.TRUMP_SUIT_HEART;
        minMaxArray[1] = getMaxNumber(mHeartTrump) + Constant.TRUMP_SUIT_HEART;
        minMaxArray[2] = getMinNumber(mDiaTrump) + Constant.TRUMP_SUIT_DIAMOND;
        minMaxArray[3] = getMaxNumber(mDiaTrump) + Constant.TRUMP_SUIT_DIAMOND;
        minMaxArray[4] = getMinNumber(mSpadeTrump) + Constant.TRUMP_SUIT_SPADE;
        minMaxArray[5] = getMaxNumber(mSpadeTrump) + Constant.TRUMP_SUIT_SPADE;
        minMaxArray[6] = getMinNumber(mClubTrump) + Constant.TRUMP_SUIT_CLUB;
        minMaxArray[7] = getMaxNumber(mClubTrump) + Constant.TRUMP_SUIT_CLUB;
        return minMaxArray;
    }

    //
    private void setTblCard(List<Integer> targetList, int suit) {
        String tableCard = "";

        Collections.sort(targetList);
        for (int spaceLoop = 1; spaceLoop <= Constant.MAX_NUMBER_OF_TRUMP; spaceLoop++) {
            if (!targetList.contains(spaceLoop)) {
                tableCard = tableCard + Constant.CARD_SPACE;
            } else {
                tableCard = tableCard + mConvertTrump.convertTrumpCard(spaceLoop + suit) + "|";
            }
        }
        System.out.println(tableCard);
    }

    // テーブルに出せる最大値を算出
    private int getMaxNumber(List<Integer> targetSuitList) {
        //最大値を求める
        int maxNum = Collections.max(targetSuitList);

        //最大値が7以外の時
        if (maxNum != Constant.TRUMP_NUMBER_SEVEN) {
            maxNum = getTargetMaxNum(maxNum, targetSuitList);
        }

        return maxNum;
    }

    private int getTargetMaxNum(int originalMaxNum, List<Integer> targetSuitList) {
        int maxNum = originalMaxNum;
        // 7までの間の数字が全部あるか確認
        for (int decrementMaxNum = originalMaxNum; decrementMaxNum < 8; decrementMaxNum--) {
            if (!targetSuitList.contains(decrementMaxNum)) {
                maxNum = decrementMaxNum;
            }
        }
        return maxNum;
    }

    private int getMinNumber(List<Integer> targetSuitList) {
        //最小値を求める
        int minNum = Collections.min(targetSuitList);
        //最小値が7以外の時
        if (minNum != Constant.TRUMP_NUMBER_SEVEN) {
            minNum = getTargetMinNum(minNum, targetSuitList);
        }
        return Collections.min(targetSuitList);
    }

    private int getTargetMinNum(int originalMinNum, List<Integer> targetSuitList) {
        int minNum = Constant.CARD_INITIAL_NUM;
        // 7までの間の数字が全部あるか確認
        for (int incrementMinNum = originalMinNum; incrementMinNum > 6; incrementMinNum++) {
            if (!targetSuitList.contains(incrementMinNum)) {
                minNum = incrementMinNum;
            }
        }
        return minNum;
    }

}

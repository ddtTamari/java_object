package shichinarabe;

import java.util.ArrayList;
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
        System.out.println("================Table===============");
        setTblCard(mHeartTrump);
        setTblCard(mDiaTrump);
        setTblCard(mSpadeTrump);
        setTblCard(mClubTrump);
        System.out.println("====================================");
    }

    private String setTblCard(List<Integer> targetList) {
        String str = "";
        String trump = "";
        for (int handsCard : targetList) {
            trump = mConvertTrump.convertTrumpCard(handsCard);
            str = str + "|" + trump;
            System.out.println(str);
        }
        return str;
    }

}

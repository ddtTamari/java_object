package shichinarabe;

import java.util.ArrayList;
import java.util.List;

public class ShichinarabePlayer extends Player {

    /**
     * メソッド名：addPlayerHand
     * @author Tamari
     * @param  card：カードの値
     * @return
     * 処理内容：プレイヤーの手札に登録する
     */
    //引数に渡されたカードを手札に登録
    public void addPlayerHand(int card) {
        //手札に登録する
        mPlayerHands.addPlayerHand(card);
    }

    //
    public List<Integer> getTheTargetNumHand(int targetNum) {
        List<Integer> havingTargetNumCD = new ArrayList<Integer>(Constant.CARD_INITIAL_NUM);
        List<Integer> havingTargetNum = new ArrayList<Integer>(Constant.CARD_INITIAL_NUM);

        for (int handLoop = 0; handLoop < mPlayerHands.getPlayerHand().size(); handLoop++) {
            if (checkHand(handLoop, targetNum)) {
                havingTargetNumCD.add(handLoop);
                havingTargetNum.add(mPlayerHands.getTrumpNum(handLoop));
            }
        }
        if (havingTargetNum.size() != 0) {
            for (int reverseHandEle = havingTargetNum.size() - 1; reverseHandEle >= 0; reverseHandEle--) {
                mPlayerHands.dropCard(havingTargetNumCD.get(reverseHandEle));
            }
        }
        return havingTargetNum;
    }

    public boolean checkHand(int trumpId, int targetNum) {
        boolean ret = false;
        ret = mPlayerHands.hasTheNum(trumpId, targetNum);
        return ret;

    }

    //デバッグ用
    public void showHands() {
        String str;
        String trump;

        str = "";
        for (int handsCard : mPlayerHands.getPlayerHand()) {
            trump = convertTrump.convertTrumpSuitMark(handsCard) + convertTrump.convertTrumpNum(handsCard);
            str = str + "|" + trump;
        }
        System.out.println(str);
    }
}

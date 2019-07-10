package shichinarabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShichinarabePlayer extends Player {

    private int mPassTime = 0;

    public ShichinarabePlayer() {
        mPassTime = Constant.PASS_TIME;
    }

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

    //7の数字を持っているかどうかを確認する
    public List<Integer> getTheTargetSevenNumHand(int targetNum) {
        List<Integer> havingTargetNumId = new ArrayList<Integer>(Constant.CARD_INITIAL_NUM);
        List<Integer> havingTargetNum = new ArrayList<Integer>(Constant.CARD_INITIAL_NUM);

        //全ての手札を確認する
        for (int handLoop = 0; handLoop < mPlayerHands.getPlayerHand().size(); handLoop++) {
            //ターゲットの数字をもっているか
            if (checkHand(handLoop, targetNum)) {
                //持っていた時の要素番号を格納
                havingTargetNumId.add(handLoop);
            }
        }

        //7が手札にあったとき
        if (havingTargetNumId.size() != 0) {
            //逆から手札を追っていき7のカードを手札から除外する
            for (int reverseHandEle = havingTargetNumId.size() - 1; reverseHandEle >= 0; reverseHandEle--) {
                //持っている数字を格納
                havingTargetNum.add(mPlayerHands.getTrumpNum(havingTargetNumId.get(reverseHandEle)));
                //手札を捨てる
                mPlayerHands.dropCard(havingTargetNumId.get(reverseHandEle));
            }
        }

        return havingTargetNum;
    }

    //7の数字を持っているかどうかを確認する
    public List<Integer> getTheTargetNumHand(int[] targetNum) {
        List<Integer> havingTargetNumId = new ArrayList<Integer>(Constant.CARD_INITIAL_NUM);
        List<Integer> havingTargetNum = new ArrayList<Integer>(Constant.CARD_INITIAL_NUM);
        Random random = new Random();
        int randomValue;

        //全ての手札を確認する
        for (int handLoop = 0; handLoop < mPlayerHands.getPlayerHand().size(); handLoop++) {
            for (int i = 0; i < targetNum.length; i++) {
                //ターゲットの数字をもっているか
                if (checkHand(handLoop, targetNum[i])) {
                    //持っていた時の要素番号を格納
                    havingTargetNumId.add(handLoop);
                }
            }
        }

        //ターゲットが手札にあったとき
        if (havingTargetNumId.size() != 0) {
            randomValue = random.nextInt(havingTargetNumId.size());
            //持っている数字を格納
            havingTargetNum.add(mPlayerHands.getTrumpNum(havingTargetNumId.get(randomValue)));
            //手札を捨てる
            mPlayerHands.dropCard(havingTargetNumId.get(randomValue));
        } else {
            mPassTime = mPassTime - 1;
        }

        return havingTargetNum;
    }

    //特定の番号を持っているか確認するメソッド
    public boolean checkHand(int trumpId, int targetNum) {
        //特定の番号を持っているかどうか確認
        return mPlayerHands.hasTheNum(trumpId, targetNum);

    }

    //パスタイムが残っているかどうか
    public List<Integer> hasPass() {
        //返却値用手札
        List<Integer> havingTargetNumId = new ArrayList<Integer>(mPlayerHands.getPlayerHand().size());

        //パス回数が残ってなければ
        if (!hasPassTime()) {
            //手札を捨てるので手札を全て渡す
            havingTargetNumId = mPlayerHands.getPlayerHand();
        }
        //手札配列を返す
        return havingTargetNumId;
    }

    //パス回数が残っているかどうか確認
    public boolean hasPassTime() {
        //パスが残っているかどうか
        boolean havePassTime = true;
        //パス回数が0個なら
        if (mPassTime == 0) {
            //パスが残っていない
            havePassTime = false;
        }
        return havePassTime;
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

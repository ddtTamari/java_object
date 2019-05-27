package shichinarabe;

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

    //７
    public int getTheNumHand(int targetNum) {
        int hasNum = 0;
        for (int handLoop = 0; handLoop < mPlayerHands.getPlayerHand().size(); handLoop++) {
            if (checkHand(handLoop, targetNum)) {
                hasNum = mPlayerHands.getTrumpNum(handLoop);
                mPlayerHands.dropCard(handLoop);
            }
        }
        return hasNum;
    }

    private boolean checkHand(int trumpId, int targetNum) {
        boolean ret = false;
        mPlayerHands.hasTheNum(trumpId, targetNum);
        return ret;

    }

}

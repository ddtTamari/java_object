package shichinarabe;

public abstract class Player implements PlayerInterface {

    protected PlayerHands mPlayerHands = new PlayerHands();

    //
    public void addPlayerHand(int card) {
    }

    /**
     * メソッド名：disCardHand
     * @author Tamari
     * @param
     * @return
     * 処理内容：手札を捨てる処理
     */
    public void disCardHand(int card) {
        mPlayerHands.dropCard(card);
    }

    /**
     * メソッド名：getNumOfHand
     * @author Tamari
     * @param
     * @return 手札の枚数(int)
     * 処理内容：プレイヤーが持っている手札の枚数を取得する
     */
    public int getNumOfHand() {
        //プレイヤーの手札の枚数を返却
        return mPlayerHands.getPlayerHand().size();
    }

    /**
     * メソッド名：isFinish
     * @author Tamari
     * @param
     * @return True : 上がり / False：上がってない(Boolean)
     * 処理内容：手札の枚数が0枚かどうか判定
     */
    public boolean isFinish() {
        boolean ret = false;//

        if (getNumOfHand() == 0) {
            ret = true;
        }
        return ret;
    }

}

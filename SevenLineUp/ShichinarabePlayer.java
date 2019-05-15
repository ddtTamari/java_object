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

    public boolean checkHand() {
        boolean ret = false;

        return ret ;

    }

}

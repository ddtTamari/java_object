package babanuki;

import java.util.List;

public abstract class HandsManage {

    private PlayersHand playersHand = new PlayersHand();

    public void setPlayerHand(int card) {
        //手札に登録する
        playersHand.setPlayerHand(card);
    }

    // カードを数字のみにするメソッド
    public int convertTrumpNum(int card) {
        //ジョーカーじゃなければ
        if (card != Constant.TRUMP_SUIT_JOKER) {
            //スート用Bitフラグを下げる
            card = card & Constant.TRUMP_LOSE_SUIT;
        }
        //カードを数字のみにした値を返す
        return card;
    }

    public List<Integer> getPlayerHand() {
        List<Integer> playerHandsList = playersHand.getPlayerHand();
        return playerHandsList;
    }


  //手札をテーブルに捨てる処理
    public void throwCard(int throwCardID) {
        //捨てるカ要素ナンバーのカードを手札から削除させる
        playersHand.dropSameCard(throwCardID);
    }

}

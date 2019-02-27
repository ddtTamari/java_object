package babanuki;

import java.util.List;

public class HandsManage {

    private PlayersHand playersHand = new PlayersHand();

    public void setPlayerHand(int card) {
        //手札に登録する
        playersHand.setPlayerHand(card);
    }

    public List<Integer> getPlayerHand() {
        List<Integer> playerHandsList = playersHand.getPlayerHand();
        return playerHandsList;
    }

    //手札をテーブルに捨てる処理
    public void throwCard(int throwCardID) {
        //捨てるカ要素ナンバーのカードを手札から削除させる
        playersHand.dropCard(throwCardID);
    }
    

}

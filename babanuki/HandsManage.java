package babanuki;

import java.util.List;

public class HandsManage {
    //プレイヤーの手札用クラス
    private PlayersHand playersHand = new PlayersHand();

    //プレイヤーの手札に登録する
    public void setPlayerHand(int card) {
        //手札に登録する
        playersHand.setPlayerHand(card);
    }

    //プレイヤーの手札を返すメソッド
    public List<Integer> getPlayerHand() {
        //手札クラスから手札を返す
        return playersHand.getPlayerHand();
    }

    //手札から引かれたときの処理
    public void throwCard(int throwCardID) {
        //捨てるカ要素ナンバーのカードを手札から削除させる
        playersHand.dropCard(throwCardID);
    }

    //そろった手札をテーブルに捨てる処理
    public void throwCard(int throwCardID, int throwCardIDTwo) {
        //捨てるカ要素ナンバーのカードを手札から削除させる
        playersHand.dropCard(throwCardID, throwCardIDTwo);
    }

}

package babanuki;

import java.util.List;

public class HandsManage {
    //プレイヤーの手札用クラス
    private PlayersHand playersHand = new PlayersHand();

    /**
     * メソッド名：setPlayerHand
     * @author Tamari
     * @param  card：カードの値
     * @return
     * 処理内容：カードをプレイヤーの手札に登録する
     */
    //プレイヤーの手札に登録する
    public void setPlayerHand(int card) {
        //手札に登録する
        playersHand.setPlayerHand(card);
    }

    /**
     * メソッド名：getPlayerHand
     * @author Tamari
     * @param
     * @return playersHand.getPlayerHand():手札のリスト
     * 処理内容：手札の一覧を返す
     */
    //プレイヤーの手札を返すメソッド
    public List<Integer> getPlayerHand() {
        //手札クラスから手札を返す
        return playersHand.getPlayerHand();
    }

    /**
     * メソッド名：setPlayerHand
     * @author Tamari
     * @param  throwCardID：引かれたカードの要素番号
     * @return
     * 処理内容：手札から1枚なくす
     */
    //手札から引かれたときの処理
    public void throwCard(int throwCardID) {
        //捨てるカ要素ナンバーのカードを手札から削除させる
        playersHand.dropCard(throwCardID);
    }

    /**
     * メソッド名：throwCard
     * @author Tamari
     * @param  throwCardID：そろったカードの要素番号１
     *          throwCardIDTwo：そろったカードの要素番号２
     * @return
     * 処理内容：そろったカードを捨てる
     */
    //そろった手札をテーブルに捨てる処理
    public void throwCard(int throwCardID, int throwCardIDTwo) {
        //捨てるカ要素ナンバーのカードを手札から削除させる
        playersHand.dropCard(throwCardID, throwCardIDTwo);
    }

}

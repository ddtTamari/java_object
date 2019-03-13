package babanuki;

import java.util.ArrayList;
import java.util.List;

//
public class PlayersHand {
    //プレイヤーの手札のリスト
    private List<Integer> playerHandsList = new ArrayList<>();
    //捨てるカードを登録するクラス
    private DiscardTable dropTable = new DiscardTable();

    //コンストラクタ
    public void playersHands() {
    }

    //手札リストに登録
    public void setPlayerHand(int inputCards) {
        //手札に加える
        playerHandsList.add(inputCards);
    }

    //カードが引かれる処理
    public void dropCard(int drpCardId) {
        //手札から引かれたカードを消す
        playerHandsList.remove(drpCardId);
    }

    //カードを捨てる処理
    public void dropCard(int drpCardId, int drpCardIdTwo) {
        //手札からそろったカードを消す
        dropTable.setDiscardList(playerHandsList.get(drpCardId), playerHandsList.get(drpCardIdTwo));
        //大きいほうの要素番号の手札を削除する
        playerHandsList.remove(drpCardId);
        //小さいほうの要素番号の手札を削除する
        playerHandsList.remove(drpCardIdTwo);

    }

    //プレイヤーの手札のリストを返す
    public List<Integer> getPlayerHand() {
        //プレイヤーの手札を返す
        return playerHandsList;
    }

}

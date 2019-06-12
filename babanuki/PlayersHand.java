package babanuki;

import java.util.ArrayList;
import java.util.List;

//
public class PlayersHand {
    //プレイヤーの手札のリスト
    private List<Integer> mPlayerHandsList = new ArrayList<>();
    //捨てるカードを登録するクラス
    private DiscardTable mDropTable = new DiscardTable();

    //コンストラクタ
    public void playersHands() {
    }

    /**
     * メソッド名：addPlayerHand
     * @author Tamari
     * @param inputCards：登録するカードの値
     * @return
     * 処理内容：手札リストに登録する
     */
    //手札リストに登録
    public void addPlayerHand(int inputCards) {
        //手札に加える
        mPlayerHandsList.add(inputCards);
    }

    /**
     * メソッド名：dropCard
     * @author Tamari
     * @param  drpCardId：除外するカードの要素番号
     * @return
     * 処理内容：手札リストから除外する
     */
    //カードが引かれる処理
    public void dropCard(int drpCardId) {
        //手札から引かれたカードを消す
        mPlayerHandsList.remove(drpCardId);
    }

    /**
     * メソッド名：dropCard
     * @author Tamari
     * @param dropCard：除外するカードの要素番号１
     *         drpCardIdTwo：除外するカードの要素番号２
     * @return
     * 処理内容：カードを二枚削除する
     */
    //カードを捨てる処理
    public void dropCard(int drpCardId, int drpCardIdTwo) {
        //手札からそろったカードを消す
        mDropTable.setDiscardList(mPlayerHandsList.get(drpCardId), mPlayerHandsList.get(drpCardIdTwo));
        //大きいほうの要素番号の手札を削除する
        mPlayerHandsList.remove(drpCardId);
        //小さいほうの要素番号の手札を削除する
        mPlayerHandsList.remove(drpCardIdTwo);

    }

    /**
     * メソッド名：getPlayerHand
     * @author Tamari
     * @param
     * @return playerHandsList：プレイヤーの手札を返す
     * 処理内容：プレイヤーの手札を返す
     */
    //プレイヤーの手札のリストを返す
    public List<Integer> getPlayerHand() {
        //プレイヤーの手札を返す
        return mPlayerHandsList;
    }

}

package babanuki;

import java.util.ArrayList;
import java.util.List;

public class PlayersHand {

    static int playerHandID = Constant.INITIAL_NUM;
    public List<Integer> playerHandsList = new ArrayList<>();

    public PlayersHand() {
        playerHandID++;
    }

    public void playersHands() {

    }

    public int getPlayerHandID() {
        return playerHandID;
    }

    public void setPlayerHand(int inputCards) {
        checkSameNum(inputCards);
        playerHandsList.add(inputCards);

    }

    public void checkSameNum(int card) {
        for (int i = Constant.INITIAL_NUM; i < playerHandsList.size(); i++) {

        }
    }

    // カードを数字のみにするメソッド
    public int convertTrumpNum(int card) {
        //左に2ずらしてスートを消す
        card = card << 2;
        //右に2ずらして数字をのみにする
        card = card >> 2;
        return card;
    }

    public void dropSameNum() {

    }

    public List<Integer> getPlayerHand() {
        return playerHandsList;
    }

}

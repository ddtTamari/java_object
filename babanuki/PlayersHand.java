package babanuki;

import java.util.ArrayList;
import java.util.List;

public class PlayersHand {

    public List<Integer> playerHandsList = new ArrayList<>();

    public void playersHands() {

    }

    //手札リストに登録
    public void setPlayerHand(int inputCards) {
        //手札に加える
        playerHandsList.add(inputCards);
    }

    public void dropSameCard(int drpCardId) {
        playerHandsList.remove(drpCardId);
    }

    public List<Integer> getPlayerHand() {
        return playerHandsList;
    }

}

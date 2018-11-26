package babanuki;

import java.util.ArrayList;
import java.util.List;

public class PlayersHand {

    public List<Integer> playerHandsList = new ArrayList<>();
    DiscardTable dropTable = new DiscardTable();

    public void playersHands() {

    }

    //手札リストに登録
    public void setPlayerHand(int inputCards) {
        //手札に加える
        playerHandsList.add(inputCards);
    }

    public void dropCard(int drpCardId) {
        dropTable.setDiscardList(playerHandsList.get(drpCardId));
        playerHandsList.remove(drpCardId);
    }

    public List<Integer> getPlayerHand() {
        return playerHandsList;
    }

}

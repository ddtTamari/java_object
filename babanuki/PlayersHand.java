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

    public void setPlayerHand(int cards) {
        playerHandsList.add(cards);
    }

}

package babanuki;

public class PlayersHand {

    static int playerHandID = Constant.INITIAL_NUM;

    public PlayersHand() {
        playerHandID++;
    }

    public int getPlayerHandID() {
        return playerHandID;
    }
}

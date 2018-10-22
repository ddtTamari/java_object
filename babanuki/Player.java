package babanuki;

public class Player {
    private String mUserName;

    //コンストラクタ群

    public Player() {
    }

    public Player(String userName) {
        this.mUserName = userName;
    }

    public void createHands() {
        PlayersHand playersHand = new PlayersHand();
    }

}

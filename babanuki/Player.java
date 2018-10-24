package babanuki;

public class Player {
    private String mUserName;
    static int playerID = Constant.INITIAL_NUM;

    //コンストラクタ群

    public Player() {
        playerID++;
    }

    public Player(String userName) {
        this.mUserName = userName;
        playerID++;
    }

    public void createHands() {
        PlayersHand playersHand = new PlayersHand();
    }

    //セッター
    public void setPlayerID() {
        playerID = playerID + 1;
    }

    //ゲッター
    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerHand(int card) {

    }

}

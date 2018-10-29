package babanuki;

public class Player {
    private String mUserName;
    static int mPlayerID = Constant.INITIAL_NUM;
    PlayersHand playersHand = new PlayersHand();

    //コンストラクタ群

    public Player() {
        mPlayerID++;
    }

    public Player(String userName) {
        this.mUserName = userName;
        mPlayerID++;
    }

    public void createHands() {

    }

    //セッター
    public void setPlayerID() {
        mPlayerID = this.mPlayerID;
    }

    //ゲッター
    public int getPlayerID() {
        return mPlayerID;
    }

    public void setPlayerHand(int card) {
        playersHand.setPlayerHand(card);
    }

}

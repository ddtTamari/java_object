package babanuki;

import java.util.List;

public class Player {
    private String mUserName;
    private static int mPlayerID = Constant.INITIAL_NUM;
    private PlayersHand playersHand = new PlayersHand();

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

    public void showHands(String id) {
        List<Integer> playersHands = playersHand.getPlayerHand();
        System.out.println(id + "さん");
        for (int a : playersHands) {
            System.out.println(a);
        }
    }

}

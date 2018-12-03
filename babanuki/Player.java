package babanuki;

import java.util.List;

public class Player {
    private String mUserName;
    private BabanukiManage manageGame = new BabanukiManage();
    private ConvertTrumpCard convertTrump = new ConvertTrumpCard();
    private List<Integer> playersHands = manageGame.getPlayerHand();

    //コンストラクタ群

    public Player() {
    }

    public Player(String userName) {
        this.mUserName = userName;
    }

    public String getPlayerName() {
        return mUserName;
    }

    //引数に渡されたカードを手札に登録
    public void setPlayerHand(int card) {
        //手札に登録する
        manageGame.setPlayerHand(card);
    }

    public void checkSameNumHand() {
        manageGame.checkSameNum();
    }

    public boolean isFinish() {
        boolean finish = false;
        if (playersHands.size() == Constant.FINISH_GAME_NUM) {
            finish = true;
        }
        return finish;
    }

    public int handsSize() {
        int handSize = playersHands.size();
        return handSize;
    }

    //カードを引く動作を行う
    public void drawPlayersHand(List<Integer> opponent) {

    }

    //手札表示用(デバッグ用)
    public void showHands(String id) {
        List<Integer> playersHands = manageGame.getPlayerHand();
        System.out.println(id + Constant.USER_HAS + playersHands.size() + Constant.NUM_OF_USER_HANDS);
        for (int elements : playersHands) {
            String suit = convertTrump.convertTrumpSuit(elements);
            String num = convertTrump.convertTrumpNum(String.valueOf(elements));
            System.out.print(suit + num);
            System.out.print("|");
        }
        System.out.println();
    }

}

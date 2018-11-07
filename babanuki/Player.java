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
            String suit = convertTrump(a);
            int num = convertTrumpNum(a);
            if (num == 63) {
                suit = "🃏";
                System.out.println(suit);

            } else {
                System.out.println(suit + num);
            }
        }
    }

    public String convertTrump(int card) {
        String suit = "";
        if ((card & Constant.TRUMP_SUIT_CLUB) == Constant.TRUMP_SUIT_CLUB) {
            suit = "♣";
        } else if ((card & Constant.TRUMP_SUIT_SPADE) == Constant.TRUMP_SUIT_SPADE) {
            suit = "♠";
        } else if ((card & Constant.TRUMP_SUIT_DIAMOND) == Constant.TRUMP_SUIT_DIAMOND) {
            suit = "♢";
        } else if ((card & Constant.TRUMP_SUIT_HEART) == Constant.TRUMP_SUIT_HEART) {
            suit = "♡";
        }
        return suit;
    }

    // カードを数字のみにするメソッド
    public int convertTrumpNum(int card) {
        //ジョーカーじゃなければ
        if (card != Constant.TRUMP_SUIT_JOKER) {
            //左に28ずらしてスートを消す
            card = card << Constant.TRUMP_LOSE_SUIT;
            //右に28ずらして数字をのみにする
            card = card >>> Constant.TRUMP_LOSE_SUIT;
        }
        //カードを数字のみにした値を返す
        return card;
    }

}

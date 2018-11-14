package babanuki;

import java.util.List;

public class Player {
    private String mUserName;
    private BabanukiManage manageGame = new BabanukiManage();

    //コンストラクタ群

    public Player() {
    }

    public Player(String userName) {
        this.mUserName = userName;
    }

    //引数に渡されたカードを手札に登録
    public void setPlayerHand(int card) {
        //手札に登録する
        manageGame.setPlayerHand(card);
    }

    public void checkSameNumHand() {
        manageGame.checkSameNum();
    }

    //手札表示用(デバッグ用)
    public void showHands(String id) {
        List<Integer> playersHands = manageGame.getPlayerHand();
        System.out.println(id + "さん");
        for (int a : playersHands) {
            String suit = convertTrump(a);
            int num = convertTrumpNum(a);
            if (num == Constant.TRUMP_SUIT_JOKER) {
                suit = "🃏";
                System.out.println(suit);
            } else {
                System.out.println(suit + num);
            }
        }
    }

    //トランプのスートを表示(デバッグ用)
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

    // カードを数字のみにするメソッド(デバッグ用)
    public int convertTrumpNum(int card) {
        //ジョーカーじゃなければ
        if (card != Constant.TRUMP_SUIT_JOKER) {
            card = card & Constant.TRUMP_LOSE_SUIT;
        }
        //カードを数字のみにした値を返す
        return card;
    }

}

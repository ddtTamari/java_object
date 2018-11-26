package babanuki;

public class ConvertTrumpCard {
    //トランプのスート変換(デバッグ用)
    public String convertTrumpSuit(int card) {
        String suit = "";
        if (card == Constant.TRUMP_SUIT_JOKER) {
            suit = "🃏";
        } else if ((card & Constant.TRUMP_SUIT_CLUB) == Constant.TRUMP_SUIT_CLUB) {
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

    // カードを数字変換(デバッグ用)
    public String convertTrumpNum(String card) {
        int cardNum = Integer.valueOf(card);
        //ジョーカーじゃなければ
        if (cardNum != Constant.TRUMP_SUIT_JOKER) {
            cardNum = cardNum & Constant.TRUMP_LOSE_SUIT;
            card = String.valueOf(cardNum);
        } else {
            card = "";
        }
        //カードを数字のみにした値を返す
        return card;
    }

    // カードを数字のみにするメソッド
    public int convertTrumpNum(int card) {
        //ジョーカーじゃなければ
        if (card != Constant.TRUMP_SUIT_JOKER) {
            //スート用Bitフラグを下げる
            card = card & Constant.TRUMP_LOSE_SUIT;
        }
        //カードを数字のみにした値を返す
        return card;
    }

}

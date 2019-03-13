package babanuki;

public class ConvertTrumpCard {
    //トランプのスート変換(デバッグ用)
    public String convertTrumpSuit(int card) {
        //スート用変数
        String suit = "";
        //jokerだけは別枠で強制的にjokerマークにする
        if (card == Constant.TRUMP_SUIT_JOKER) {
            //jokerマークに変換
            suit = "🃏";
            //クラブのビットが立ってれば
        } else if ((card & Constant.TRUMP_SUIT_CLUB) == Constant.TRUMP_SUIT_CLUB) {
            //クラブに変換
            suit = "♣";
            //スペードのビットが立ってれば
        } else if ((card & Constant.TRUMP_SUIT_SPADE) == Constant.TRUMP_SUIT_SPADE) {
            //スペードに変換
            suit = "♠";
            //ダイヤのビットが立ってれば
        } else if ((card & Constant.TRUMP_SUIT_DIAMOND) == Constant.TRUMP_SUIT_DIAMOND) {
            //ダイヤに変換
            suit = "♢";
            //ハートのビットが立ってれば
        } else if ((card & Constant.TRUMP_SUIT_HEART) == Constant.TRUMP_SUIT_HEART) {
            //ハートに変換
            suit = "♡";
        }
        //変換したスートを返す
        return suit;
    }

    // カードを数字変換(デバッグ用)
    public String convertTrumpNum(String card) {
        int cardNum = Integer.valueOf(card);
        ///jokerの時は数字を変換しないのではじく
        if (cardNum != Constant.TRUMP_SUIT_JOKER) {
            //スートのビットを消す
            cardNum = cardNum & Constant.TRUMP_LOSE_SUIT;
            //数字を文字列にして返す
            card = String.valueOf(cardNum);
            //ジョーかの時は数字の部分を消す
        } else {
            //数字の部分を消す
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

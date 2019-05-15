package shichinarabe;

public class ConvertTrumpCard {
    /**
     * メソッド名：convertTrumpSuit
     * @author Tamari
     * @param  card : カードの値
     * @return suit : スートのマーク
     * 処理内容：数値で格納されているカードの値をスートに変換する
     */
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

    /**
     * メソッド名：convertTrumpNum
     * @author Tamari
     * @param  card : カードの値
     * @return card : トランプの数字
     * 処理内容：数値で格納されているカードの値を数字のみに変換する
     */
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

package babanuki;

import java.util.List;

public class BabanukiManage extends HandsManage {
    private int mThrowCardId = Constant.INITIAL_NUM;

    //同じ番号があるかどうかを確認する
    public boolean checkSameNum(int card, List<Integer> playerHandsList) {

        //受け取ったカードを数字だけで見る
        int receiveCardNum = convertTrumpNum(card);
        //もともとの手札の数字だけで見るための変数
        int handsCardNum = Constant.INITIAL_NUM;
        //同じ数字かどうか
        boolean sameNum = false;

        //手札の数だけ確認を行う
        for (int i = Constant.INITIAL_NUM; i < playerHandsList.size(); i++) {
            //要素番号の手札を数字のみにする
            handsCardNum = convertTrumpNum(playerHandsList.get(i).intValue());
            //同じ数字かどうかを判定する
            sameNum = judgeSameNum(receiveCardNum, handsCardNum);
            //同じ数字だったら
            if (sameNum) {
                //同じ数字だった手札リストの数字を捨てる
                throwCard(i);
                //捨てる処理に入ったので手札の確認を終了する
                break;
            }
        }

        //同じ数字かどうかを返す
        return sameNum;
    }

    // カードを数字のみにするメソッド
    public int convertTrumpNum(int card) {
        //ジョーカーじゃなければ
        if (card != Constant.TRUMP_SUIT_JOKER) {
            //左に2ずらしてスートを消す
            card = card << Constant.TRUMP_LOSE_SUIT;
            //右に2ずらして数字をのみにする
            card = card >> Constant.TRUMP_LOSE_SUIT;
        }
        //カードを数字のみにした値を返す
        return card;
    }

    //同じ数字かどうか確認する
    public boolean judgeSameNum(int recive, int hands) {
        //同じ数字かどうかを格納する変数
        boolean sameNum = false;
        //受け取ったカードと手札のカードで同じ数字かどうかを判定するための変数
        int checkNum = recive & hands;
        //受け取ったカードと、ANDで立っているフラグの数字が一緒だったなら同じ数字になる
        if (recive == checkNum) {
            //同じ数字にTrueを返す
            sameNum = true;
        }
        //同じ数字かどうかを返す
        return sameNum;
    }

    //手札をテーブルに捨てる処理
    public int throwCard(int throwCardID) {
        //捨てるカードの要素ナンバーを取得
        int throwID = throwCardID;
        setThrowCardId(throwID);
        //捨てカードの要素を返す
        return throwID;
    }

    public void setThrowCardId(int throwID) {
        mThrowCardId = throwID;
    }

    public int getThrowCardId() {
        return mThrowCardId;
    }

}

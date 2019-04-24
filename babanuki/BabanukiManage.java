package babanuki;

import java.util.List;

public class BabanukiManage extends HandsManage {
    private List<Integer> mPlayerHands = getPlayerHand();//プレイヤーの手を入れるメソッド
    private ConvertTrumpCard mConvertTrump = new ConvertTrumpCard();//文字列変換クラス

    /**
     * メソッド名：checkSameNum
     * @author Tamari
     * @param
     * @return
     * 処理内容：カードが配られたときに手札を確認するメソッド
     */
    //最初に同じ番号があるかどうかを確認するメソッド
    public void checkSameNum() {
        int handsCheckCardNum = Constant.CARD_INITIAL_NUM;
        //もともとの手札の数字だけで見るための変数
        int handsCardNum = Constant.CARD_INITIAL_NUM;
        //同じ数字かどうか
        boolean isSameNum = false;

        //手札の数だけ確認を行う
        for (int handsId = 0; handsId < mPlayerHands.size(); handsId++) {
            //手札の確認を行う対象のカードを数字のみにする
            handsCheckCardNum = mConvertTrump.convertTrumpNum(mPlayerHands.get(handsId).intValue());
            //全ての手札の枚数分確認を行う
            for (int checkId = 0; checkId < mPlayerHands.size(); checkId++) {
                //今見ているカードと同じIDのカードは除外する
                if (handsId != checkId) {
                    //要素番号の手札を数字のみにする
                    handsCardNum = mConvertTrump.convertTrumpNum(mPlayerHands.get(checkId).intValue());
                    //同じ数字かどうかを判定する
                    isSameNum = isSameNum(handsCheckCardNum, handsCardNum);
                }
                //同じ数字だったら
                if (isSameNum) {
                    //同じ数字だった手札リストの数字を捨てる
                    throwSameCard(handsId, checkId);
                    //カードを捨てて手札のIDが変わったので確認する手札のIDをリセットする
                    handsId = Constant.CARD_INITIAL_NUM;
                    //対象のIDのカードはもう捨てたので処理を抜ける
                    break;
                }
            }
        }
    }

    //同じ数字かどうか確認する
    private boolean isSameNum(int handsCheckCardNum, int handsCardNum) {
        //同じ数字かどうかを格納する変数
        boolean isSameNum = false;
        //受け取ったカードと、ANDで立っているフラグの数字が一緒だったなら同じ数字になる
        if (handsCheckCardNum == handsCardNum) {
            //同じ数字にTrueを返す
            isSameNum = true;
        }
        //同じ数字かどうかを返す
        return isSameNum;
    }

    //手札を捨てる処理
    private void throwSameCard(int throwCardIdOne, int throwCardIdTwo) {
        //要素が大きいほうから消す
        if (throwCardIdOne < throwCardIdTwo) {
            //左の引数が大きいほうの要素数になるようカードを消す
            throwCard(throwCardIdTwo, throwCardIdOne);
            //一枚目の位置が二枚目の位置より大きいとき
        } else {
            //左の引数が大きいほうの要素数になるようカードを消す
            throwCard(throwCardIdOne, throwCardIdTwo);
        }
    }
    /**
     * メソッド名：retCard
     * @author Tamari
     * @param  getCardId : カードの要素番号
     * @return playerHands.get(getCardId) : 引数で受け取ったカードの数字を返す
     * 処理内容：指定された要素番号のカードの値を返す
     */
    //指定されたindexの数字を返す
    public int retCard(int getCardId) {
        //指定された手札のindexの数字を返す
        return mPlayerHands.get(getCardId);
    }

}

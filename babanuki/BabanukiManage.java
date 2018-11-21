package babanuki;

import java.util.List;

public class BabanukiManage extends HandsManage {
    private List<Integer> playerHands = getPlayerHand();

    //最初に同じ番号があるかどうかを確認するメソッド
    public void checkSameNum() {
        int handsCheckCardNum = Constant.INITIAL_NUM;
        //もともとの手札の数字だけで見るための変数
        int handsCardNum = Constant.INITIAL_NUM;
        //同じ数字かどうか
        boolean sameNum = false;

        //手札の数だけ確認を行う
        for (int handsId = Constant.INITIAL_NUM; handsId < playerHands.size(); handsId++) {
            handsCheckCardNum = convertTrumpNum(playerHands.get(handsId).intValue());
            for (int checkId = Constant.INITIAL_NUM; checkId < playerHands.size(); checkId++) {
                if (handsId != checkId) {
                    //要素番号の手札を数字のみにする
                    handsCardNum = convertTrumpNum(playerHands.get(checkId).intValue());
                    //同じ数字かどうかを判定する
                    sameNum = judgeSameNum(handsCheckCardNum, handsCardNum);
                }
                //同じ数字だったら
                if (sameNum) {
                    //同じ数字だった手札リストの数字を捨てる
                    throwSameCard(handsId, checkId);
                    //確認する手札のIDをリセットする
                    handsId = Constant.INITIAL_NUM;
                    break;
                }
            }
        }
    }

    //同じ数字かどうか確認する
    public boolean judgeSameNum(int handsCheckCardNum, int handsCardNum) {
        //同じ数字かどうかを格納する変数
        boolean sameNum = false;
        //受け取ったカードと、ANDで立っているフラグの数字が一緒だったなら同じ数字になる
        if (handsCheckCardNum == handsCardNum) {
            //同じ数字にTrueを返す
            sameNum = true;
        }
        //同じ数字かどうかを返す
        return sameNum;
    }

    //手札を捨てる処理
    public void throwSameCard(int throwCardIdOne, int throwCardIdTwo) {
        if (throwCardIdOne < throwCardIdTwo) {
            throwCard(throwCardIdTwo);
            throwCard(throwCardIdOne);
        } else {
            throwCard(throwCardIdOne);
            throwCard(throwCardIdTwo);
        }
    }

}

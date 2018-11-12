package babanuki;

import java.util.List;

public class BabanukiManage extends HandsManage {

    //同じ番号があるかどうかを確認する
    public boolean checkSameNum(List<Integer> playerHandsList) {
        int handsCheckNum = Constant.INITIAL_NUM;
        //もともとの手札の数字だけで見るための変数
        int handsCardNum = Constant.INITIAL_NUM;
        //同じ数字かどうか
        boolean sameNum = false;

        //手札の数だけ確認を行う
        for (int handsId = Constant.INITIAL_NUM; handsId < (playerHandsList.size() / Constant.HALF_NUM); handsId++) {
            handsCheckNum = convertTrumpNum(playerHandsList.get(handsId).intValue());
            for (int checkId = Constant.INITIAL_NUM; checkId < playerHandsList.size(); checkId++) {
                //要素番号の手札を数字のみにする
                handsCardNum = convertTrumpNum(playerHandsList.get(checkId).intValue());
                //同じ数字かどうかを判定する
                sameNum = judgeSameNum(handsCardNum, handsCardNum);
                //同じ数字だったら
                if (sameNum) {
                    //同じ数字だった手札リストの数字を捨てる
                    throwCard(handsCardNum);
                    throwCard(checkId);
                    //捨てる処理に入ったので手札の確認を終了する
                    break;
                }
            }
        }
        //同じ数字かどうかを返す
        return sameNum;
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

}

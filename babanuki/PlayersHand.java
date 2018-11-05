package babanuki;

import java.util.ArrayList;
import java.util.List;

public class PlayersHand {

    public List<Integer> playerHandsList = new ArrayList<>();
    BabanukiManage babanukiAction = new BabanukiManage();

    public void playersHands() {

    }

    public void setPlayerHand(int inputCards) {
        //同じ数字が手札にないか確認を行う
        boolean sameNum = babanukiAction.checkSameNum(inputCards, playerHandsList);
        int removeCardId = Constant.INITIAL_NUM;

        //同じ数字の手札がないときの処理
        if (!sameNum) {
            //手札に加える
            playerHandsList.add(inputCards);
            //手札にあればそのカードを消す
        } else if (sameNum) {
            removeCardId = babanukiAction.getThrowCardId();
            playerHandsList.remove(removeCardId);
        }
    }

    public void dropSameNum() {

    }

    public List<Integer> getPlayerHand() {
        return playerHandsList;
    }

}

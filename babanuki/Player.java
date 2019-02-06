package babanuki;

import java.util.List;
import java.util.Scanner;

public class Player {
    private String mUserName;
    private BabanukiManage manageBabaGame = new BabanukiManage();
    private ConvertTrumpCard convertTrump = new ConvertTrumpCard();
    private List<Integer> playersHands = manageBabaGame.getPlayerHand();
    Scanner userImput = new Scanner(System.in);

    //コンストラクタ群

    public Player() {
    }

    public Player(String userName) {
        this.mUserName = userName;
    }

    public String getPlayerName() {
        return mUserName;
    }

    //引数に渡されたカードを手札に登録
    public void setPlayerHand(int card) {
        //手札に登録する
        manageBabaGame.setPlayerHand(card);
    }

    public void removePlayerHand(int cardId) {
        manageBabaGame.throwCard(cardId);
    }


    public void checkSameNumHand() {
        //同じ数字があるかどうかを確認
        manageBabaGame.checkSameNum();
    }

    //手札がなくなったプレイヤーじゃないか確認
    public boolean isFinish() {
        //手札0かどうかの判定をする変数
        boolean finish = false;
        //プレイヤーの手札のサイズが0の時
        if (playersHands.size() == Constant.INITIAL_NUM) {
            //終わったか判定する
            finish = true;
        }
        //手札0かどうかを返す
        return finish;
    }

    public int handsSize() {
        int handSize = playersHands.size();
        return handSize;
    }

    //指定するインデックスのカードを返す
    public int retHands(int getCardId) {
        //指定されたインデックスのカード格納する変数
        int card = manageBabaGame.retCard(getCardId);
        //カードを返却する
        return card;
    }

    //カードを引く動作を行う
    public void drawPlayersHand(Player opponent) {
        //カードが引かれる手札の位置
        int drawPosition = Constant.INITIAL_NUM;
        //手札の枚数の範囲で指定するまで繰り返す
        while (Constant.INITIAL_NUM >= drawPosition || drawPosition > opponent.handsSize()) {
            //どのポジションを引くか聞く
            System.out.println(mUserName + Constant.ASK_DRAW_POSITION);
            //キーボードから値を取得する
            drawPosition = userImput.nextInt();
        }
        //カードの引かれる位置を要素数になるよう合わせる
        drawPosition = drawPosition - Constant.ADJUST_ELEMENT_NUM;


        //引いたプレイヤーの手札に新たに引いたカードを追加する
        setPlayerHand(opponent.retHands(drawPosition));
        //引かれたプレイヤーのカードを削除する
        opponent.removePlayerHand(drawPosition);
    }

    //引いたカードがそろっていないか確認する
    public void checkDrawCard(int drawCardNum) {
        manageBabaGame.checkDrawCard(drawCardNum);
    }

    //手札表示用(デバッグ用)
    public void showHands(String id) {
        List<Integer> playersHands = manageBabaGame.getPlayerHand();
        System.out.println(id + Constant.USER_HAS + playersHands.size() + Constant.NUM_OF_USER_HANDS);
        for (int elements : playersHands) {
            String suit = convertTrump.convertTrumpSuit(elements);
            String num = convertTrump.convertTrumpNum(String.valueOf(elements));
            System.out.print(suit + num);
            System.out.print("|");
        }
        System.out.println();
    }

}

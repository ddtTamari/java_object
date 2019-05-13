package shichinarabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShichiFacilitator {

    private List<Player> mPlayerList = new ArrayList<Player>();

    int mPlayerNum = Constant.PLAYER_INITIAL_NUM;

    public void startShichiNarabe() {
        //  トランプクラスを用意する
        Card trumpDeck = new Card();

        // カードをシャッフル
        trumpDeck.shuffleCards(false);
        //プレイヤーリスト作成
        mPlayerList = initialSetGameSetting();

        initialAction(trumpDeck, mPlayerNum);

    }

    private List<Player> initialSetGameSetting() {
        int playerNum = Constant.PLAYER_INITIAL_NUM; //  プレイヤーの人数を格納する変数

        // プレイヤーの人数を確認する
        playerNum = setPlayerNum();

        List<Player> cPlayerList = new ArrayList<Player>(playerNum); // 現在プレイしているプレイヤーリスト

        //プレイヤーの人数になるまで繰り返す
        for (int playerCount = 0; playerCount < playerNum; playerCount++) {
            cPlayerList.add(new ShichinarabePlayer());
        }

        return cPlayerList;
    }

    // プレイヤー人数の取得
    private int setPlayerNum() {

        int intPlayerNum = 0;//戻り値用
        Random rndNum = new Random(); //Playerの数をランダムで決めるため宣言

        // プレイヤー人数用の変数に格納
        intPlayerNum = rndNum.nextInt(Constant.MAX_PLAYER_NUM) + 1;

        //プレイ人数を表示
        System.out.println(intPlayerNum + MessageConstant.OUTPUT_PLAYER_NUM_MESSAGE);

        //プレイヤーの人数を返す
        return intPlayerNum;
    }

    private void initialAction(Card trump, int playerNum) {

        // カードを配る
        distribution(trump, mPlayerNum);
        // 7を場に出す

    }

    // 配る処理
    private void distribution(Card trump, int playerNum) {
        // どのプレイヤーに配るかIDを用意しておく
        int playerID = Constant.PLAYER_INITIAL_NUM;
        // プレイヤーに渡すカード
        int inputCard = Constant.CARD_INITIAL_NUM;

        // 52枚配り終わるまで繰り返す
        for (int trumpID = 0; trumpID < Constant.MAX_TRUMP_NUM; trumpID++) {
            // プレイヤーに渡すカードを取得する
            inputCard = getCard(trump, trumpID);
            // プレイヤーに配る処理を行う
            distributionPlayer(inputCard, playerID);
            // 次のプレイヤーに配る人を変える
            playerID = playerID + 1;
            // プレイヤーがmax行くまで繰り返す
            if (playerID == playerNum) {
                // 初期化する
                playerID = Constant.PLAYER_INITIAL_NUM;
            }
        }
    }

    // プレイヤークラスに手札としてカードを配る
    private void distributionPlayer(int card, int playerID) {
        // 引数に渡されたカードをプレイヤーに渡す
        mPlayerList.get(playerID).addPlayerHand(card);
    }

    // カードクラスから指定された番号のカードを返す
    private int getCard(Card trump, int element) {
        // 加える手札として返す
        return trump.returnCard(element);
    }
}

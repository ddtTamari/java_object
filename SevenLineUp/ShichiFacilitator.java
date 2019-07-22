package shichinarabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShichiFacilitator {

    private List<ShichinarabePlayer> mPlayerList = new ArrayList<ShichinarabePlayer>();
    private List<ShichinarabePlayer> mFinishPlayerList = new ArrayList<ShichinarabePlayer>();//上がったプレイヤーリスト
    private List<ShichinarabePlayer> mDisqualificationPlayer = new ArrayList<ShichinarabePlayer>();

    private int mPlayerNum = Constant.PLAYER_INITIAL_NUM;
    private DiscardTable table = new DiscardTable();

    public void startShichiNarabe() {
        //  トランプクラスを用意する
        Card trumpDeck = new Card();

        // カードをシャッフル
        trumpDeck.shuffleCards(false);
        //プレイヤーリスト作成
        mPlayerList = initialSetGameSetting();

        initialAction(mPlayerList, trumpDeck, mPlayerNum);

        mainShichinarabeAction();

    }

    private List<ShichinarabePlayer> initialSetGameSetting() {
        // プレイヤーの人数を確認する
        setPlayerNum();

        List<ShichinarabePlayer> cPlayerList = new ArrayList<ShichinarabePlayer>(mPlayerNum); // 現在プレイしているプレイヤーリスト
        //プレイヤーの人数になるまで繰り返す
        for (int playerCount = 0; playerCount < mPlayerNum; playerCount++) {
            cPlayerList.add(new ShichinarabePlayer());
        }

        return cPlayerList;
    }

    // プレイヤー人数の設定
    private void setPlayerNum() {

        Random rndNum = new Random(); //Playerの数をランダムで決めるため宣言

        // プレイヤー人数用の変数に格納
        mPlayerNum = rndNum.nextInt(Constant.MAX_PLAYER_NUM) + 3;

        //プレイ人数を表示
        System.out.println(mPlayerNum + MessageConstant.OUTPUT_PLAYER_NUM_MESSAGE);
    }

    private void initialAction(List<ShichinarabePlayer> players, Card trump, int playerNum) {
        // カードを配る
        distribution(trump, playerNum);
        //デバッグ用
        for (ShichinarabePlayer player : players) {
            player.showHands();
        }
        // 7を場に出す
        putDownACardSeven(players);
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

    //７のカードを出させる
    private void putDownACardSeven(List<ShichinarabePlayer> players) {

        int sevenNumCard[] = { Constant.TRUMP_NUMBER_SEVEN | Constant.TRUMP_SUIT_HEART,
                Constant.TRUMP_NUMBER_SEVEN | Constant.TRUMP_SUIT_DIAMOND,
                Constant.TRUMP_NUMBER_SEVEN | Constant.TRUMP_SUIT_SPADE,
                Constant.TRUMP_NUMBER_SEVEN | Constant.TRUMP_SUIT_CLUB };

        List<Integer> putSevenCard = new ArrayList<>();
        for (int playerLoop = 0; playerLoop < players.size(); playerLoop++) {
            putSevenCard = players.get(playerLoop).getTheTargetSevenNumHand(sevenNumCard);
            if (putSevenCard.size() != 0) {
                for (int card : putSevenCard) {
                    table.registTable(card);
                }
            }
        }
        table.showTable();
    }

    private void mainShichinarabeAction() {
        int[] canPlayCardList;
        int trunPlayerID = 0;
        //プレイしているプレイヤーがいなくなるまで繰り返す
        do {
            canPlayCardList = table.setCanPlayCard();
            //プレイヤーに出せるカードがあるか確認してもらう
            mPlayerList.get(trunPlayerID).getTheTargetNumHand(canPlayCardList);
            //終了しているプレイヤーがいるかどうか
            checkFinishPlayer(mPlayerList.get(trunPlayerID), trunPlayerID);

            //次のプレイヤーへ
            trunPlayerID++;
            //プレイヤー人数より次の人のIDが大きくなった時
            if (trunPlayerID > mPlayerList.size()) {
                //ターンプレイヤーをリセット
                trunPlayerID = 0;
            }

        } while (mPlayerList.size() != 0);

    }

    private void checkFinishPlayer(ShichinarabePlayer targetPlayer, int turnUserId) {
        //対象のプレイヤーが終わっているかどうか確認
        if (targetPlayer.isFinish()) {
            //終わったプレイヤーに追加
            mFinishPlayerList.add(targetPlayer);
            //プレイ中のリストから削除
            mPlayerList.remove(turnUserId);
            // 失格者かどうか
        } else if (targetPlayer.hasPass().size() != 0) {
            // 失格者の手札をテーブルに出力
            for (int card : targetPlayer.hasPass()) {
                //テーブルに登録
                table.registTable(card);
            }
            //失格リストに追加
            mDisqualificationPlayer.add(targetPlayer);
            //プレイ中のリストから削除
            mPlayerList.remove(turnUserId);
        }
    }

    // カードクラスから指定された番号のカードを返す
    private int getCard(Card trump, int element) {
        // 加える手札として返す
        return trump.returnCard(element);
    }

}
